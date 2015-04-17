package org.apache.spark.streaming;
/**
 * An object that counts the number of started / completed batches. This is implemented using a
 * StreamingListener. Constructing a new instance automatically registers a StreamingListener on
 * the given StreamingContext.
 */
public  class BatchCounter {
  public   BatchCounter (org.apache.spark.streaming.StreamingContext ssc) { throw new RuntimeException(); }
  private  int numCompletedBatches () { throw new RuntimeException(); }
  private  int numStartedBatches () { throw new RuntimeException(); }
  private  java.lang.Object listener () { throw new RuntimeException(); }
  public  int getNumCompletedBatches () { throw new RuntimeException(); }
  public  int getNumStartedBatches () { throw new RuntimeException(); }
}
