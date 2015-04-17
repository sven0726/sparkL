package org.apache.spark.streaming;
/**
 * This testsuite tests master failures at random times while the stream is running using
 * the real clock.
 */
public  class FailureSuite extends org.scalatest.FunSuite implements org.apache.spark.streaming.TestSuiteBase, org.apache.spark.Logging {
  public   FailureSuite () { throw new RuntimeException(); }
  public  java.lang.String directory () { throw new RuntimeException(); }
  public  int numBatches () { throw new RuntimeException(); }
  public  org.apache.spark.streaming.Duration batchDuration () { throw new RuntimeException(); }
  public  boolean useManualClock () { throw new RuntimeException(); }
  public  void afterFunction () { throw new RuntimeException(); }
}
