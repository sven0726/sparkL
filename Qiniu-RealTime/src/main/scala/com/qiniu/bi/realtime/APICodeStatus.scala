package com.qiniu.bi.realtime
import java.util.Date

import com.qiniu.bi.common.RealtimeUtil
import kafka.producer.{KeyedMessage, ProducerConfig, Producer}
import kafka.serializer.DefaultDecoder
import org.apache.avro.io.{DatumReader, _}
import org.apache.avro.specific.SpecificDatumReader
import org.apache.flume.source.avro.AvroFlumeEvent
import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import java.util.Properties
import scala.collection.immutable._

/**
 * Created by qiniu on 15/5/5.
 */

/**
 *
 * Example:
 * $ bin/run-example com.qiniu.bi.realtime.APICodeStatus <zkQuorum> <group> <topics> <numThreads>"
 */

object APICodeStatus {


  //Kafka producer
  val getKafkaProducer = {
    val props = new Properties();

    props.put("metadata.broker.list", "nb1380:9092,nb1381:9092,nb1382:9092,nb1383:9092");
    props.put("serializer.class", "kafka.serializer.StringEncoder");
    //props.put("partitioner.class", "example.producer.SimplePartitioner");
    props.put("request.required.acks", "1");
    props.put("producer.type", "async");//async ,so it batch the data

    val config: ProducerConfig = new ProducerConfig(props);
    new Producer[String, String](config)
  }


  /**
   * a record
   * @param time  日志时间
   * @param service 服务名
   * @param instance 服务实例名
   * @param host 服务实例所在服务器名
   * @param method 请求方式
   * @param code  请求响应码
   */
  case class ApiCodeRecord(time: String, service: String, instance: String, host: String, method: String, code: String)

  def main(args: Array[String]) {

    if (args.length < 4) {
      System.err.println("REQ_PFDTrackerRate <zkQuorum> <group> <topics> <checkpointDir> ")
      System.exit(1)
    }


    StreamingExamples.setStreamingLogLevels()

    val Array(zkQuorum, group, topics, checkpointDir) = args
    val sparkConf = new SparkConf().setAppName("APICodeStatus_" + new Date().getTime)
    println(sparkConf.get("spark.streaming.batch"))
    val batchDuration = sparkConf.get("spark.streaming.batch")
    val ssc = new StreamingContext(sparkConf, Seconds(batchDuration.toInt))

    ssc.checkpoint(checkpointDir)

    val topicMap = topics.split(",").map((_, 2)).toMap

    val numInputMessages = ssc.sparkContext.accumulator(0L, "Kafka messages consumed")

    /*val producerPool = {
      val pool = createKafkaProducerPool(kafkaZkCluster.kafka.brokerList, outputTopic.name)
      ssc.sparkContext.broadcast(pool)
    }*/


    val kafkaStream = {
      val sparkStreamingConsumerGroup = group
      val kafkaParams = Map[String, String](
        "zookeeper.connect" -> "nb1380:2181,nb1381:2181,nb1382:2181,nb1383:2181,nb1387:2181",
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
      var event: AvroFlumeEvent = new AvroFlumeEvent()
      var decoder:BinaryDecoder = null

      /**
       * 对partition进行处理
       */
      val res = for (e <- it) yield {
      //val res = it.map(e=>{
        //累计处理的消息数
        numInputMessages += 1

        decoder = DecoderFactory.get().binaryDecoder(e, decoder)

        event = reader.read(event, decoder)
        val headers = RealtimeUtil.toStringMap(event.getHeaders)
        if (headers.getOrElse("service", "NULL").startsWith("REQ")) {
          val bodyStr = RealtimeUtil.getBodyAsString(event.getBody)
          val r = bodyStr.split("\t")
          if (r.length == 14)
          //case class ApiCodeRecord(time:String,service:String,instance:String,host:String,method:String,code:String)
            //record = ApiCodeRecord(r(2).substring(0,10), r(1), r(12), r(13), r(3), r(7))
            ((r(1), r(12), r(13), r(3), r(7)),r(2).substring(0,10))
          else {
            /* println(bodyStr)
             var i: Int = -1
             r.map(x => {
               i += 1
               (x, i)
             }).foreach(println)*/
            null
          }

        }else
          null

      }

      res.filter(_!=null)
    })

   /* value.foreachRDD(rdd=>{

    })*/


    //value.print()

    //case class ApiCodeRecord(time: String, service: String, instance: String, host: String, method: String, code: String)

    //val tenSecodsValue = value.map(x => ((x.service, x.instance, x.host, x.method, x.code), (x.time, 1))).groupByKey(2)
    val tenSecodsValue = value.map(x => (x._1, (x._2.toLong, 1))).groupByKey(2)


    tenSecodsValue.foreachRDD(rdd=>{
      rdd.foreachPartition{ record=>
        record.foreach(x=>{
          var minTime: Long = Long.MaxValue
          var maxTime: Long = Long.MinValue
          var count: Int = 0
          x._2.foreach(m => {
            minTime = Math.min(minTime, m._1.toLong)
            maxTime = Math.max(maxTime, m._1.toLong)
            count += m._2
          })
          val data = new KeyedMessage[String, String]("apiCode_t", (minTime, maxTime, x._1, count).toString())
          getKafkaProducer.send(data)

          //println("已处理消息：" + data)
        })
      }
    })


   /* val ff = tenSecodsValue.map(x => {
      var minTime: Long = Long.MaxValue
      var maxTime: Long = Long.MinValue
      var count: Int = 0
      x._2.foreach(m => {
        minTime = Math.min(minTime, m._1.toLong)
        maxTime = Math.max(maxTime, m._1.toLong)
        count += m._2
      })
      val data = new KeyedMessage[String, String]("apiCode_t", (minTime, maxTime, x._1, count).toString())
      getKafkaProducer.send(data)
      println("已处理消息：" + numInputMessages )
      (minTime, maxTime, x._1, count)
    })

    ff.print()*/
    ssc.start()
    ssc.awaitTermination()

  }

}




