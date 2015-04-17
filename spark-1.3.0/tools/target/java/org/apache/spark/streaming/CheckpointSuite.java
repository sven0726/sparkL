package org.apache.spark.streaming;
/**
 * This test suites tests the checkpointing functionality of DStreams -
 * the checkpointing of a DStream's RDDs as well as the checkpointing of
 * the whole DStream graph.
 */
public  class CheckpointSuite extends org.scalatest.FunSuite implements org.apache.spark.streaming.TestSuiteBase {
  static public  boolean batchThreeShouldBlockIndefinitely () { throw new RuntimeException(); }
  public   CheckpointSuite () { throw new RuntimeException(); }
  public  org.apache.spark.streaming.StreamingContext ssc () { throw new RuntimeException(); }
  public  org.apache.spark.streaming.Duration batchDuration () { throw new RuntimeException(); }
  public  void beforeFunction () { throw new RuntimeException(); }
  public  void afterFunction () { throw new RuntimeException(); }
  /**
   * Tests a streaming operation under checkpointing, by restarting the operation
   * from checkpoint file and verifying whether the final output is correct.
   * The output is assumed to have come from a reliable queue which an replay
   * data as required.
   * <p>
   * NOTE: This takes into consideration that the last batch processed before
   * master failure will be re-processed after restart/recovery.
   */
  public <U extends java.lang.Object, V extends java.lang.Object> void testCheckpointedOperation (scala.collection.Seq<scala.collection.Seq<U>> input, scala.Function1<org.apache.spark.streaming.dstream.DStream<U>, org.apache.spark.streaming.dstream.DStream<V>> operation, scala.collection.Seq<scala.collection.Seq<V>> expectedOutput, int initialNumBatches, scala.reflect.ClassTag<U> evidence$1, scala.reflect.ClassTag<V> evidence$2) { throw new RuntimeException(); }
  /**
   * Advances the manual clock on the streaming scheduler by given number of batches.
   * It also waits for the expected amount of time for each batch.
   */
  public <V extends java.lang.Object> scala.collection.Seq<scala.collection.Seq<V>> advanceTimeWithRealDelay (org.apache.spark.streaming.StreamingContext ssc, long numBatches, scala.reflect.ClassTag<V> evidence$3) { throw new RuntimeException(); }
}
