import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by qiniu on 15-4-17.
 */
object TestJobGrooup {

  def main(args: Array[String]): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("test Job group")
    val sc = new SparkContext(conf)
    sc.setJobGroup("some_job_to_cancel", "some job description")
    val result = sc.parallelize(1 to 10000, 2).map { i => Thread.sleep(10); i }.count()
    print(result)

    sc.stop()
  }
}
