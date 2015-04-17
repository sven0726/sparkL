package org.apache.spark.streaming;
public  class BasicOperationsSuite extends org.scalatest.FunSuite implements org.apache.spark.streaming.TestSuiteBase {
  public   BasicOperationsSuite () { throw new RuntimeException(); }
  public  scala.collection.immutable.Seq<scala.collection.Seq<java.lang.Object>> cleanupTestInput () { throw new RuntimeException(); }
  /** Test cleanup of RDDs in DStream metadata */
  public <T extends java.lang.Object> org.apache.spark.streaming.dstream.DStream<T> runCleanupTest (org.apache.spark.SparkConf conf2, scala.Function1<org.apache.spark.streaming.dstream.DStream<java.lang.Object>, org.apache.spark.streaming.dstream.DStream<T>> operation, int numExpectedOutput, org.apache.spark.streaming.Duration rememberDuration, scala.reflect.ClassTag<T> evidence$1) { throw new RuntimeException(); }
}
