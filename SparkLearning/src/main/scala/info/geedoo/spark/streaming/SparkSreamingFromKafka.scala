package info.geedoo.spark.streaming

import java.util.Properties

import _root_.kafka.producer.{KeyedMessage, Producer, ProducerConfig}
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.kafka._
import org.apache.spark.SparkConf


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


/**
 * Created by qiniu on 15-4-24.
 * 从kafka 里面读取数据做单词统计
 */
object KafkaWordCount {

  def main (args: Array[String]) {
    if(args.size<4){
        System.err.print("Using KafkaWordCount <zkQuorum> <group> <topics> <numThreads>")
        System.exit(1)
    }

    //StreamingExamples.setStreamingLogLevels()

    //取得参数
    val Array(zkQuorum,group,topics,numThreads) = args
    val conf = new SparkConf().setMaster("local[2]").setAppName("KafkaWordCount")
    val scc = new StreamingContext(conf,Seconds(2))
    scc.checkpoint("./spark/streaming/kafka")
    val topicMap = topics.split(",").map((_,numThreads.toInt)).toMap
    /**创建Kafka input stream*/
    val lines = KafkaUtils.createStream(scc,zkQuorum,group,topicMap).map(_._2)

    val words = lines.flatMap(_.split(" "))
    /**使用更加高效的reduceByKeyAndWindow(func, invFunc, windowLength, slideInterval, [numTasks])计算
      * 用法详见：http://spark.apache.org/docs/latest/streaming-programming-guide.html
      * */
    val wordCounts = words.map(x=>(x,1L)).reduceByKeyAndWindow(_+_,_-_,Seconds(10),Seconds(4),3)

    wordCounts.print()

    scc.start()
    scc.awaitTermination()
  }

}


// Produces some random words between 1 and 100.
object KafkaWordCountProducer{
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
    val producer = new Producer[String,String](config)
    // Send some messages
    while(true){
      val messages = (1 to messagesPerSec.toInt).map{messageNum =>
        val str = (1 to wordsPerMessage.toInt).map(x=>scala.util.Random.nextInt(10).toString).mkString(" ")
        new KeyedMessage[String,String](topic,str)
      }.toArray

      producer.send(messages: _*)
    }
  }
}
