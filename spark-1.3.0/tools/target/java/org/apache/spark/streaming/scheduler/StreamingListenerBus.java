package org.apache.spark.streaming.scheduler;
/** Asynchronously passes StreamingListenerEvents to registered StreamingListeners. */
public  class StreamingListenerBus extends org.apache.spark.util.AsynchronousListenerBus<org.apache.spark.streaming.scheduler.StreamingListener, org.apache.spark.streaming.scheduler.StreamingListenerEvent> implements org.apache.spark.Logging {
  public   StreamingListenerBus () { throw new RuntimeException(); }
  private  java.util.concurrent.atomic.AtomicBoolean logDroppedEvent () { throw new RuntimeException(); }
  public  void onPostEvent (org.apache.spark.streaming.scheduler.StreamingListener listener, org.apache.spark.streaming.scheduler.StreamingListenerEvent event) { throw new RuntimeException(); }
  public  void onDropEvent (org.apache.spark.streaming.scheduler.StreamingListenerEvent event) { throw new RuntimeException(); }
}
