package com.qiniu.bi.realtime

import java.nio.{CharBuffer, ByteBuffer}
import java.nio.charset.{CharsetDecoder, Charset}
import java.util.{Date, Properties}

import _root_.kafka.producer.{KeyedMessage, Producer, ProducerConfig}
import kafka.serializer.DefaultDecoder
import org.apache.avro.specific.SpecificDatumReader
import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Minutes, Seconds, StreamingContext}
import org.apache.avro.io.DatumReader
import org.apache.flume.source.avro.AvroFlumeEvent
import org.apache.avro.io._
import java.io._
import scala.collection.immutable._
import scala.util.{Failure, Success}

/**
 * Created by qiniu on 15/5/5.
 */

/**
 * Consumes messages from one or more topics in Kafka and does wordcount.
 * Usage: DirectKafkaWordCount <brokers> <topics>
 *   <brokers> is a list of one or more Kafka brokers
 *   <topics> is a list of one or more kafka topics to consume from
 *
 * Example:
 *    $ bin/run-example com.qiniu.bi.realtime.REQ_PFDTrackerRate <zkQuorum> <group> <topics> <numThreads>"
 */

object REQ_PFDTrackerRate_C {

  /**
   * Helper function to convert a map of CharSequence to a map of String.
   */

  def toStringMap(charSeqMap :java.util.Map[CharSequence,CharSequence]):Map[String,String] = {
    val stringMap = new scala.collection.mutable.HashMap[String,String]
    import scala.collection.JavaConversions._
    charSeqMap.foreach(kv=>{
      stringMap += (kv._1.toString -> kv._2.toString)
    })

//    for(key : CharSequence <- charSeqMap.keySet)
//      stringMap += (key.toString -> charSeqMap.get(key).toString)

    stringMap.toMap
  }

  def main(args: Array[String]) {

    if (args.length<4){
      System.err.println("REQ_PFDTrackerRate <zkQuorum> <group> <topics> <numThreads>")
      System.exit(1)
    }

    //implicit val specificAvroBinaryInjectionForTweet = SpecificAvroCodecs.toBinary[AvroFlumeEvent]

    val decoder :BinaryDecoder = null;
    var in : ByteArrayInputStream = null;
    //val reader:DatumReader = new SpecificDatumReader[AvroFlumeEvent](classOf(AvroFlumeEvent))
    //val reader:DatumReader = new SpecificDatumReader[AvroFlumeEvent](scala.reflect.classTag[AvroFlumeEvent].asInstanceOf[Class[AvroFlumeEvent]])

    StreamingExamples.setStreamingLogLevels()

    val Array(zkQuorum,group,topics,numThreads) = args
    val sparkConf = new SparkConf().setMaster("local[12]").setAppName("REQ_PFDTrackerRate_" + new Date().getTime)
    val ssc = new StreamingContext(sparkConf,Seconds(1))

    ssc.checkpoint("./checkpoint")

    val topicMap = topics.split(",").map((_,numThreads.toInt)).toMap

    val numInputMessages = ssc.sparkContext.accumulator(0L, "Kafka messages consumed")

/*
    val events = KafkaUtils.createStream(scc,zkQuorum,group,topicMap).map(_._2).map(x=> {
      in = new ByteArrayInputStream(x.getBytes)
      var event:AvroFlumeEvent = null
      event = reader.read(event,decoder);
      //val e = EventBuilder.withBody(event.getBody().array(),toStringMap(event.getHeaders()));

      println("Event-->" + event.toString)
      event
    })

    val count = events.count()

    count.print()*/
    val kafkaStream = {
      val sparkStreamingConsumerGroup = "spark-streaming-consumer-group2"
       val kafkaParams = Map[String, String](
      "zookeeper.connect" -> "nb1380:2181,nb1381:2181,nb1382:2181,nb1383:2181,nb1387:2181",
      "group.id" -> sparkStreamingConsumerGroup,
      // CAUTION: Spark's use of auto.offset.reset is DIFFERENT from Kafka's behavior!
      // https://issues.apache.org/jira/browse/SPARK-2383
      //"auto.offset.reset" -> "smallest", // must be compatible with when/how we are writing the input data to Kafka
      "zookeeper.connection.timeout.ms" -> "1000")

  val streams = (1 to 3) map { _ =>
    KafkaUtils.createStream[Array[Byte], Array[Byte], DefaultDecoder, DefaultDecoder](
      ssc,
      kafkaParams,
      topicMap,
      storageLevel = StorageLevel.MEMORY_AND_DISK_SER // or: StorageLevel.MEMORY_AND_DISK_SER
    ).map(_._2)
  }
  val unifiedStream = ssc.union(streams)

  unifiedStream.repartition(numThreads.toInt)
  }
    // We also use a broadcast variable for Bijection/Injection.

    //converter.value.

    // Define the actual data flow of the streaming job

    def getBodyAsString(buffer:ByteBuffer):String = {
      val charset :Charset  = Charset.forName("UTF-8")

      val decoder:CharsetDecoder = charset.newDecoder()
      val charBuffer:CharBuffer  = decoder.decode(buffer.asReadOnlyBuffer());

      // charBuffer = decoder.decode(buffer);//用这个的话，只能输出来一次结果，第二次显示为空

      charBuffer.toString()
    }

    //val decoder:BinaryDecoder = null
    val value = kafkaStream.map(bytes=>{
      val reader:DatumReader[AvroFlumeEvent] = new SpecificDatumReader[AvroFlumeEvent](classOf[AvroFlumeEvent])

      var e : AvroFlumeEvent = new AvroFlumeEvent()
      val decoder = DecoderFactory.get().binaryDecoder(bytes,null)
      e  = reader.read(e,decoder)
      //println("-------------------------start")
      //println(bytes.getClass)
      //println("Schema:\t" + e.getSchema.toString(true))
      //println("Header:\t" + e.getHeaders.toString)
      //println("Body:\t" + e.getBody.asCharBuffer())
      //println("Body:\t" + getBodyAsString(e.getBody))
      //println("-------------------------end")
      //String.valueOf(bytes)
      //e.getBody.toString
      e
  }).map{ case e =>
      val service = toStringMap(e.getHeaders).get("service")
      //val headers = e.getHeaders
      //headers.
     /* println("---------strat")
      println("Header:\t" + e.getHeaders.keySet().toString)
      println("Header:\t" + e.getHeaders.containsKey("service"))
      println("Header:\t" + e.getHeaders.containsValue("APP_IMAGE"))
      println("Header:\t" + e.getHeaders.toString)
      println("service -> " + service)
      println("--------end")*/
        service match {
          case Some("APP_IMAGE") => {
            //println("e:->  " + e.toString)
            1
          }
          case _ => 0
        }
    }
    /*val value = kafkaStream.map { case bytes =>
      numInputMessages += 1
      //val converter = ssc.sparkContext.broadcast(specificAvroBinaryInjectionForTweet)
      converter.value.invert(bytes) match {
        case Success(tweet) => {
          println("打印Schema：" + tweet.getSchema)
          println("打印Headers：" + tweet.getHeaders)
          println("打印Body：" + tweet.getBody)
          tweet
        }
        case Failure(e) =>
      }
    }*//*.foreachRDD(rdd => {
      rdd.foreachPartition(partitionOfRecords => {
        val p = producerPool.value.borrowObject()
        partitionOfRecords.foreach { case tweet: Tweet =>
          val bytes = converter.value.apply(tweet)
          p.send(bytes)
          numOutputMessages += 1
        }
        producerPool.value.returnObject(p)
      })
    })*/
    value.map{x=>print(_)
      print(",")}

    val result = value.reduceByWindow(_+_,Seconds(6),Seconds(2))
    result.print()
    ssc.start()
    ssc.awaitTermination()

  }

}


/**
 * Consumes messages from one or more topics in Kafka and does wordcount.
 * Usage: KafkaWordCount <zkQuorum> <group> <topics> <numThreads>
 *   <zkQuorum> is a list of one or more zookeeper servers that make quorum
 *   <group> is the name of kafka consumer group
 *   <topics> is a list of one or more kafka topics to consume from
 *   <numThreads> is the number of threads the kafka consumer should use
 *
 * Example:
 *    `$ bin/run-example \
 *      org.apache.spark.examples.streaming.KafkaWordCount zoo01,zoo02,zoo03 \
 *      my-consumer-group topic1,topic2 1`
 */
object KafkaWordCount {
  def main(args: Array[String]) {
    if (args.length < 4) {
      System.err.println("Usage: KafkaWordCount <zkQuorum> <group> <topics> <numThreads>")
      System.exit(1)
    }

    StreamingExamples.setStreamingLogLevels()

    val Array(zkQuorum, group, topics, numThreads) = args
    val sparkConf = new SparkConf().setAppName("KafkaWordCount")
    val ssc =  new StreamingContext(sparkConf, Seconds(2))
    ssc.checkpoint("checkpoint")

    val topicMap = topics.split(",").map((_,numThreads.toInt)).toMap
    val lines = KafkaUtils.createStream(ssc, zkQuorum, group, topicMap).map(_._2)
    val words = lines.flatMap(_.split(" "))
    val wordCounts = words.map(x => (x, 1L))
      .reduceByKeyAndWindow(_ + _, _ - _, Minutes(10), Seconds(2), 2)
    wordCounts.print()

    ssc.start()
    ssc.awaitTermination()
  }
}

// Produces some random words between 1 and 100.
object KafkaWordCountProducer {

  def main(args: Array[String]) {
    if (args.length < 4) {
      System.err.println("Usage: KafkaWordCountProducer <metadataBrokerList> <topic> " +
        "<messagesPerSec> <wordsPerMessage>")
      System.exit(1)
    }

    val Array(brokers, topic, messagesPerSec, wordsPerMessage) = args

    // Zookeeper connection properties
    val props = new Properties()
    props.put("metadata.broker.list", brokers)
    props.put("serializer.class", "kafka.serializer.StringEncoder")

    val config = new ProducerConfig(props)
    val producer = new Producer[String, String](config)

    // Send some messages
    while(true) {
      val messages = (1 to messagesPerSec.toInt).map { messageNum =>
        val str = (1 to wordsPerMessage.toInt).map(x => scala.util.Random.nextInt(10).toString)
          .mkString(" ")

        new KeyedMessage[String, String](topic, str)
      }.toArray

      producer.send(messages: _*)
      Thread.sleep(100)
    }
  }

}