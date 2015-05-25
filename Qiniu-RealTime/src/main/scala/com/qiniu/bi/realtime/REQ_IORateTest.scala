package com.qiniu.bi.realtime

import java.text.SimpleDateFormat
import java.util.Date

import com.mongodb.casbah.commons.MongoDBObject
import com.qiniu.bi.common.RealtimeUtil
import kafka.serializer.DefaultDecoder
import org.apache.avro.io.{DatumReader, _}
import org.apache.avro.specific.SpecificDatumReader
import org.apache.flume.source.avro.AvroFlumeEvent
import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.immutable._
import scala.util.parsing.json.JSON
import org.apache.spark.Logging

import org.apache.log4j.{Level, Logger}

/**
 * Created by qiniu on 15/5/5.
 */

/**
 * Example:
 * $ bin/run-example com.qiniu.bi.realtime.REQ_IORate <zkQuorum> <group> <topics> <numThreads> <checkpoint> <mongoUrl>"
 */

object REQ_IORateTest {

  //Logger.getLogger(classOf[])

  def main(args: Array[String]) {

    if (args.length < 6) {
      System.err.println("REQ_IORate <zkQuorum> <group> <topics> <parallelism> <checkpoint> <mongoUrl>")
      System.exit(1)
    }


    StreamingExamples.setStreamingLogLevels()
    val dayHourFormat = new SimpleDateFormat("yyyyMMdd-HH")
    val dayFormat = new SimpleDateFormat("yyyyMMdd")
    val timeFormat = new SimpleDateFormat("HH:mm:ss")
    val dateFormat = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss SSS")

    val Array(zkQuorum, groupName, topics, parallelism, checkpoint, mongoUrl) = args
    val sparkConf = new SparkConf().setAppName("REQ_IORate_" + new Date().getTime)
    val batchDuration = sparkConf.get("spark.streaming.batch")
    val ssc = new StreamingContext(sparkConf, Seconds(batchDuration.toInt))

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

      val streams = (1 to 12) map { _ =>
        KafkaUtils.createStream[Array[Byte], Array[Byte], DefaultDecoder, DefaultDecoder](
          ssc,
          kafkaParams,
          topicMap,
          storageLevel = StorageLevel.MEMORY_AND_DISK_SER // or: StorageLevel.MEMORY_AND_DISK_SER
        ).map(_._2)
      }
      //val unifiedStream = ssc.union(streams)
      ssc.union(streams)

      //unifiedStream.repartition(parallelism.toInt)
    }

    val value = kafkaStream.mapPartitions(it => {
      val reader: DatumReader[AvroFlumeEvent] = new SpecificDatumReader[AvroFlumeEvent](classOf[AvroFlumeEvent])

      var e: AvroFlumeEvent = new AvroFlumeEvent()

      var decoder: BinaryDecoder = null
      val res = it.map(bytes => {
        decoder = DecoderFactory.get().binaryDecoder(bytes, decoder)
        e = reader.read(e, decoder)
        val service = RealtimeUtil.toStringMap(e.getHeaders).get("service")
        if (Some("REQ_IO") == service){
          val bodyStr = RealtimeUtil.getBodyAsString(e.getBody)
          if (bodyStr != null) {
            val bodyS = bodyStr.split("\t")
            if (bodyS.length == 14) {
              //val json = JSON.parseFull(bodyS(5))
              val queryBody = bodyS(5)
              if(queryBody.contains("X-Real-Ip"))
                1
              else {

                val ipreg = """(10|172|127|192).[0-9]+.[0-9]+.[0-9]+""".r ////以10 127 172 192开头的为内网ip
                if(ipreg.findFirstIn(queryBody)==None)  //如果找不到匹配的ip则说明不是内网ip
                  1
              }

            }
          }
        }

      })

      /*val t1 = dateFormat.format(System.currentTimeMillis())
      println(Thread.currentThread().getName + ":" + t1)
      var count = 0
       val res = it.map(bytes => {
         numInputMessages += 1
         println(bytes.length)
         count += 1

         decoder = DecoderFactory.get().binaryDecoder(bytes, decoder)
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

                   try {

                     val json = JSON.parseFull(bodyS(5))

                     /*val getHeaderJson: Map[String, Any] = {
                       if (json != None) json.get.asInstanceOf[Map[String, Any]] else null
                     }*/

                     //ssc.sparkContext.broadcast()
                     /* val realIp = {
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
                      }*/
                     flag = true
                    } catch {

                      case e => {
                        println(bodyS(5))

                        e.printStackTrace()
                      }
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
 */
      Iterator(res.count(_ == 1))

    })

    // val countByOneMinutsPerSecond = value.countByValue(2)
    val countByOneMinutsPerSecond = value.reduce(_ + _)
    //val result = value.reduceByWindow(_ + _, Seconds(60), Seconds(1))
    //val countByOneMinutsPerSecond = value.reduceByWindow(_ + _, _ - _, Seconds(1), Seconds(1))
    //val countByOneMinutsPerSecond = value.countByWindow(Seconds(1),Seconds(1))//ByWindow(_ + _, _ - _, Seconds(1), Seconds(1))
    //result.print()

    if (mongoUrl == "test") {
      val result = countByOneMinutsPerSecond.map(x => {
        (new Date().getTime, x)
      })

      result.print()
    }
    else {
      countByOneMinutsPerSecond.foreachRDD(rdd => rdd.foreachPartition(p => {
        import com.mongodb.casbah._
        //val mongoClientURI = MongoClientURI("mongodb://115.231.182.84:27017/")
        val mongoClientURI = MongoClientURI(mongoUrl)
        val mongoClient = MongoClient(mongoClientURI)
        //val mongoClient = MongoClient("115.231.182.84",27017)
        val db = mongoClient("io_rate")

        p.foreach(x => {

          val datetime = new Date()
          //dayFormat.format(datetime)
          val coll = db("IO_" + dayFormat.format(datetime))
          val key = "R" + dayHourFormat.format(datetime)
          val query = MongoDBObject("_id" -> key)

          //val update = MongoDBObject({"$push"->{"tt"->timeFormat.format(datetime),"rr"->x._2.toLong}})
          val update = MongoDBObject("$push" -> MongoDBObject("tt" -> timeFormat.format(datetime)))
          val update2 = MongoDBObject("$push" -> MongoDBObject("rr" -> x.toLong))
          /*builder += ("_id"->key)
          builder += ("$push"->{"tt"->timeFormat.format(datetime)})
          builder += ("$push"->{"rr"->x._2.toLong})*/
          //val update = MongoDBObject("_id"->key) ++ ("$push"->{"tt"->timeFormat.format(datetime)})
          println(update2)
          coll.update(query, update2, upsert = true)
          coll.update(query, update, upsert = true)

          mongoClient.close()
        })

      }))

    }


    ssc.start()
    ssc.awaitTermination()

  }

}




