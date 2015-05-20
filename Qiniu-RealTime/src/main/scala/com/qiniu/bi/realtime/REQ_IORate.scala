package com.qiniu.bi.realtime

import com.qiniu.bi.common.RealtimeUtil
import java.util.{Date}
import com.mongodb.casbah.commons.MongoDBObject
import kafka.serializer.DefaultDecoder
import org.apache.avro.io.{DatumReader, _}
import org.apache.avro.specific.SpecificDatumReader
import org.apache.flume.source.avro.AvroFlumeEvent
import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import java.text.SimpleDateFormat
import scala.collection.immutable._

import scala.util.parsing.json.JSON

/**
 * Created by qiniu on 15/5/5.
 */

/**
 * Example:
 * $ bin/run-example com.qiniu.bi.realtime.REQ_IORate <zkQuorum> <group> <topics> <numThreads> <checkpoint> <mongoUrl>"
 */

object REQ_IORate {


  def main(args: Array[String]) {

    if (args.length < 6) {
      System.err.println("REQ_IORate <zkQuorum> <group> <topics> <parallelism> <checkpoint> <mongoUrl>")
      System.exit(1)
    }


    StreamingExamples.setStreamingLogLevels()
    val dayHourFormat = new SimpleDateFormat("yyyyMMdd-HH")
    val dayFormat = new SimpleDateFormat("yyyyMMdd")
    val timeFormat = new SimpleDateFormat("HH:mm:ss")
    //val dateFormat = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss Z")

    val Array(zkQuorum, groupName, topics, parallelism,checkpoint,mongoUrl) = args
    val sparkConf = new SparkConf().setAppName("REQ_IORate_" + new Date().getTime)
    val ssc = new StreamingContext(sparkConf, Seconds(1))

    //ssc.checkpoint("./checkpoint222")
    ssc.checkpoint(checkpoint)

    val topicMap = topics.split(",").map((_, 2)).toMap

    val numInputMessages = ssc.sparkContext.accumulator(0L, "Kafka messages consumed")

    val kafkaStream = {
      val sparkStreamingConsumerGroup = groupName
      val kafkaParams = Map[String, String](
        //"zookeeper.connect" -> "nb1380:2181,nb1381:2181,nb1382:2181,nb1383:2181,nb1387:2181",
        "zookeeper.connect" -> zkQuorum,
        "group.id" -> sparkStreamingConsumerGroup,
        // CAUTION: Spark's use of auto.offset.reset is DIFFERENT from Kafka's behavior!
        // https://issues.apache.org/jira/browse/SPARK-2383
        //"auto.offset.reset" -> "smallest", // must be compatible with when/how we are writing the input data to Kafka
        "zookeeper.connection.timeout.ms" -> "1000")

      val streams = (1 to 16) map { _ =>
        KafkaUtils.createStream[Array[Byte], Array[Byte], DefaultDecoder, DefaultDecoder](
          ssc,
          kafkaParams,
          topicMap,
          storageLevel = StorageLevel.MEMORY_AND_DISK_SER // or: StorageLevel.MEMORY_AND_DISK_SER
        ).map(_._2)
      }
      val unifiedStream = ssc.union(streams)

      unifiedStream.repartition(parallelism.toInt)
    }

    val value = kafkaStream.mapPartitions(it => {
      val reader: DatumReader[AvroFlumeEvent] = new SpecificDatumReader[AvroFlumeEvent](classOf[AvroFlumeEvent])

      var e: AvroFlumeEvent = new AvroFlumeEvent()

      val res = it.map(bytes=>{
        numInputMessages += 1

        val decoder = DecoderFactory.get().binaryDecoder(bytes, null)
        e = reader.read(e, decoder)
        val service = RealtimeUtil.toStringMap(e.getHeaders).get("service")
        service match {
          case Some("REQ_IO") => {
            val isRealIp: Boolean = {
              var flag = false
              val bodyStr = RealtimeUtil.getBodyAsString(e.getBody)
              if (bodyStr != null) {
                val bodyS = bodyStr.split("\t")
                if (bodyS.length == 14) {
                  //println(bodyS(5))
                  /* var getHeaderJson: Map[String, Any] = null
                   try {
                     val json = JSON.parseFull(bodyS(5))
                     if (json != None)
                       getHeaderJson = json.get.asInstanceOf[Map[String, Any]]
                   } catch {
                     case e:Exception => {

                      /* println(e.toString)
                       println("---->" + bodyS(5))
                       e.printStackTrace()*/
                     }
                   }*/
                  try {
                    val json = JSON.parseFull(bodyS(5))
                    val getHeaderJson: Map[String, Any] = {
                      if (json != None) json.get.asInstanceOf[Map[String, Any]] else null
                    }

                    //println(getHeaderJson)
                    //println(s)
                    val realIp = {
                      if (getHeaderJson != null) getHeaderJson.get("X-Real-Ip") else None
                    }
                    //println("realIp!=null" + (realIp != null) + " realIp = " + realIp)
                    if (realIp != None && realIp.get != "")
                      flag = true
                    else {
                      println(" realIp = " + realIp)
                      val ip = {
                        if (getHeaderJson != null) getHeaderJson.get("IP").get.toString else ""
                      }
                      //以10 127 172 192开头的为内网ip
                      if (ip.startsWith("10.") || ip.startsWith("127.") || ip.startsWith("172.") || ip.startsWith("192"))
                        flag = false
                      else
                        flag = true
                    }
                  }catch{
                    case _ =>
                  }

                }

              }
              flag
            }
            if (isRealIp) 1 else 0

          }
          case _ => 0
        }
      })

      res

    }).filter(_==1)

    val countByOneMinutsPerSecond = value.countByValue(2)//countByValueAndWindow(Seconds(60), Seconds(60), 1)
    //val result = value.reduceByWindow(_ + _, Seconds(60), Seconds(1))
    //val result = value.reduceByWindow(_+_,_-_,Seconds(60),Seconds(1))
    //result.print()

    val result = countByOneMinutsPerSecond.map(x =>{
      import com.mongodb.casbah._
      //val mongoClientURI = MongoClientURI("mongodb://115.231.182.84:27017/")
      val mongoClientURI = MongoClientURI(mongoUrl)
      val mongoClient = MongoClient(mongoClientURI)
      //val mongoClient = MongoClient("115.231.182.84",27017)
      val db = mongoClient("io_rate")
      val datetime = new Date()
      //dayFormat.format(datetime)
      val coll = db("IO_" + dayFormat.format(datetime))
      val key = "R" + dayHourFormat.format(datetime)
      val query = MongoDBObject("_id" -> key)

      //val update = MongoDBObject({"$push"->{"tt"->timeFormat.format(datetime),"rr"->x._2.toLong}})
      val update = MongoDBObject("$push"->MongoDBObject("tt"->timeFormat.format(datetime)))
      val update2 = MongoDBObject("$push"->MongoDBObject("rr"->x._2.toLong))
      /*builder += ("_id"->key)
      builder += ("$push"->{"tt"->timeFormat.format(datetime)})
      builder += ("$push"->{"rr"->x._2.toLong})*/
      //val update = MongoDBObject("_id"->key) ++ ("$push"->{"tt"->timeFormat.format(datetime)})
      println(update2)
      coll.update(query,update2,upsert=true)
      coll.update(query,update,upsert=true)

      mongoClient.close()
      (new Date().getTime,x._2)
    })

    result.print()
    ssc.start()
    ssc.awaitTermination()

  }

}




