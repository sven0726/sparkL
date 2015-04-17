import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.SparkContext._

/**
 * Created by qiniu on 15-4-17.
 */
object DistinctTest {

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setMaster("local").setAppName("dd"))
    val keys =  Array("aa","aa","ss","ss","as")


    val ss = sc.parallelize(keys).map(x=>(x,null)).reduceByKey((x,y)=>x).map(_._1)

    ss.foreach(println _)
    println("-------------")
    print(ss.toDebugString)
  }
}
