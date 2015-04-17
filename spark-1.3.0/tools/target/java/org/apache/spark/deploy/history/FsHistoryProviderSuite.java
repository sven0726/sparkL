package org.apache.spark.deploy.history;
public  class FsHistoryProviderSuite extends org.scalatest.FunSuite implements org.scalatest.BeforeAndAfter, org.scalatest.Matchers, org.apache.spark.Logging {
  public   FsHistoryProviderSuite () { throw new RuntimeException(); }
  private  java.io.File testDir () { throw new RuntimeException(); }
  /** Create a fake log file using the new log format used in Spark 1.3+ */
  private  java.io.File newLogFile (java.lang.String appId, boolean inProgress, scala.Option<java.lang.String> codec) { throw new RuntimeException(); }
  private  void writeFile (java.io.File file, boolean isNewFormat, scala.Option<org.apache.spark.io.CompressionCodec> codec, scala.collection.Seq<org.apache.spark.scheduler.SparkListenerEvent> events) { throw new RuntimeException(); }
  private  void createEmptyFile (java.io.File file) { throw new RuntimeException(); }
  private  org.apache.spark.SparkConf createTestConf () { throw new RuntimeException(); }
}
