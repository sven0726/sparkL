package info.geedoo.spark.streaming


import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.kafka._
import org.apache.spark.SparkConf


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
