/**
 * Created by qiniu on 15-4-16.
 */

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
object SimpleApp {

  def main(args: Array[String]){
    val conf = new SparkConf().setAppName("Test wordcount").setMaster("local[1]")
    val sc = new SparkContext(conf)

    val logFile = "file:///home/qiniu/work/spark/spark-1.3.0/README.md"

    val content = sc.textFile(logFile,2)
    val result = content.count();
    println(result)
    sc.stop()

  }
}
