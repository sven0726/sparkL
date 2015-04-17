package org.apache.spark.metrics;
public  class InputOutputMetricsSuite extends org.scalatest.FunSuite implements org.apache.spark.SharedSparkContext, org.scalatest.BeforeAndAfter {
  public   InputOutputMetricsSuite () { throw new RuntimeException(); }
  public  java.io.File tmpDir () { throw new RuntimeException(); }
  public  java.io.File tmpFile () { throw new RuntimeException(); }
  public  java.lang.String tmpFilePath () { throw new RuntimeException(); }
  public  int numRecords () { throw new RuntimeException(); }
  public  int numBuckets () { throw new RuntimeException(); }
  private  long runAndReturnBytesRead (scala.Function0<scala.runtime.BoxedUnit> job) { throw new RuntimeException(); }
  private  long runAndReturnRecordsRead (scala.Function0<scala.runtime.BoxedUnit> job) { throw new RuntimeException(); }
  private  long runAndReturnRecordsWritten (scala.Function0<scala.runtime.BoxedUnit> job) { throw new RuntimeException(); }
  private  long runAndReturnShuffleRecordsRead (scala.Function0<scala.runtime.BoxedUnit> job) { throw new RuntimeException(); }
  private  long runAndReturnShuffleRecordsWritten (scala.Function0<scala.runtime.BoxedUnit> job) { throw new RuntimeException(); }
  private  long runAndReturnMetrics (scala.Function0<scala.runtime.BoxedUnit> job, scala.Function1<org.apache.spark.scheduler.SparkListenerTaskEnd, scala.Option<java.lang.Object>> collector) { throw new RuntimeException(); }
}
