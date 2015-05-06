package com.qiniu.bi.realtime

import java.util.{Date, Properties}

import _root_.kafka.producer.{KeyedMessage, Producer, ProducerConfig}
import org.apache.avro.specific.SpecificDatumReader
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Minutes, Seconds, StreamingContext}
import org.apache.avro.io.DatumReader
import org.apache.flume.source.avro.AvroFlumeEvent
import org.apache.flume.event.EventBuilder
import org.apache.avro.io._
import java.io._
import scala.collection.immutable._
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

object REQ_PFDTrackerRate {

  /**
   * Helper function to convert a map of CharSequence to a map of String.
   */
//  private static Map<String, String> toStringMap(
//    Map<CharSequence, CharSequence> charSeqMap) {
//    Map<String, String> stringMap =
//      new HashMap<String, String>();
//    for (Map.Entry<CharSequence, CharSequence> entry : charSeqMap.entrySet()) {
//      stringMap.put(entry.getKey().toString(), entry.getValue().toString());
//    }
//    return stringMap;
//  }

  def toStringMap(charSeqMap :Map[CharSequence,CharSequence]):Map[String,String] = {
    val stringMap = new scala.collection.mutable.HashMap[String,String]

    for(entry <- charSeqMap.keys)
      stringMap += (String.valueOf(entry)->String.valueOf(charSeqMap(entry)))

    stringMap.toMap
  }

  def main(args: Array[String]) {

    if (args.length<4){
      System.err.println("REQ_PFDTrackerRate <zkQuorum> <group> <topics> <numThreads>")
      System.exit(1)
    }
    val decoder :BinaryDecoder = null;
    var in : ByteArrayInputStream = null;
    //val reader:DatumReader = new SpecificDatumReader[AvroFlumeEvent](classOf(AvroFlumeEvent))
    //val reader:DatumReader = new SpecificDatumReader[AvroFlumeEvent](scala.reflect.classTag[AvroFlumeEvent].asInstanceOf[Class[AvroFlumeEvent]])
    val reader:DatumReader[AvroFlumeEvent] = new SpecificDatumReader[AvroFlumeEvent](classOf[AvroFlumeEvent])

    StreamingExamples.setStreamingLogLevels()

    val Array(zkQuorum,group,topics,numThreads) = args
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("REQ_PFDTrackerRate_" + new Date().getTime)
    val scc = new StreamingContext(sparkConf,Seconds(2))

    scc.checkpoint("./checkpoint")

    val topicMap = topics.split(",").map((_,numThreads.toInt)).toMap

    val events = KafkaUtils.createStream(scc,zkQuorum,group,topicMap).map(_._2).map(x=> {
      in = new ByteArrayInputStream(x.getBytes)
      var event:AvroFlumeEvent = null
      event = reader.read(event,decoder);
      //val e = EventBuilder.withBody(event.getBody().array(),toStringMap(event.getHeaders()));

      println("Event-->" + event.toString)
      event
    })

    val count = events.count()

    count.print()

    scc.start()
    scc.awaitTermination()

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