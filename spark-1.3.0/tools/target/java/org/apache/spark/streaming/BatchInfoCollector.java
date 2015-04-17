package org.apache.spark.streaming;
/** Listener that collects information on processed batches */
public  class BatchInfoCollector implements org.apache.spark.streaming.scheduler.StreamingListener {
  public   BatchInfoCollector () { throw new RuntimeException(); }
  public  scala.collection.mutable.ArrayBuffer<org.apache.spark.streaming.scheduler.BatchInfo> batchInfos () { throw new RuntimeException(); }
  public  void onBatchCompleted (org.apache.spark.streaming.scheduler.StreamingListenerBatchCompleted batchCompleted) { throw new RuntimeException(); }
}
