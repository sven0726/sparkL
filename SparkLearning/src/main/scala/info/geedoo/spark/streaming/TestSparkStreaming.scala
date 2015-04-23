package info.geedoo.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._


/**
 * Created by qiniu on 15-4-20.
 */
object TestSparkStreaming {
  def main(args: Array[String]): Unit ={
    val conf = new SparkConf().setAppName("test sparkstreaming").setMaster("local[2]")
    val scc = new StreamingContext(conf,Seconds(5))
    scc.checkpoint("./spark/streaming/back")
    val lines = scc.socketTextStream("localhost",9999)

    val words = lines.flatMap(_.split(" "))
    val pairs = words.map(word => (word, 1))
    val wordCounts = pairs.reduceByKey(_ + _)

    /**
     * updateWorcCountState更新执行结果，需要配置checkpoint目录。
     * newValues新接受到的值序列
     * runningCount是已经累计的值
     * */
    def updateWorcCountState(newValues: Seq[Int],runningCount:Option[Int]):Option[Int] = {
      val newCount = newValues.fold(runningCount.getOrElse(0))(_+_)/***/
     /* println("newValues[" + newValues.toString+"]")
      newValues.foreach(print _+",")
      println("runningCount[" + runningCount.getOrElse(-1)+"]")*/
      Some(newCount)
    }
    /**传入上面定义的状态更新函数*/
    val runingcounts = pairs.updateStateByKey(updateWorcCountState _)

    println("runingcountsruningcountsruningcountsruningcounts--------------" + runingcounts)/**只会执行一次，以后急不会啦。 runingcounts是个DStream*/
    /**没有调用output操作的话是不会执行任务的*/
    //runingcounts.checkpoint(new Duration(1))
    runingcounts.print()
    //wordCounts.print()
    scc.start()
    scc.awaitTermination()
  }
}
