package org.apache.spark.streaming;
public  class ReceivedBlockTrackerSuite extends org.scalatest.FunSuite implements org.scalatest.BeforeAndAfter, org.scalatest.Matchers, org.apache.spark.Logging {
  public   ReceivedBlockTrackerSuite () { throw new RuntimeException(); }
  public  org.apache.hadoop.conf.Configuration hadoopConf () { throw new RuntimeException(); }
  public  scala.concurrent.duration.FiniteDuration akkaTimeout () { throw new RuntimeException(); }
  public  int streamId () { throw new RuntimeException(); }
  public  scala.collection.mutable.ArrayBuffer<org.apache.spark.streaming.scheduler.ReceivedBlockTracker> allReceivedBlockTrackers () { throw new RuntimeException(); }
  public  java.io.File checkpointDirectory () { throw new RuntimeException(); }
  public  org.apache.spark.SparkConf conf () { throw new RuntimeException(); }
  /**
   * Create tracker object with the optional provided clock. Use fake clock if you
   * want to control time by manually incrementing it to test log cleanup.
   */
  public  org.apache.spark.streaming.scheduler.ReceivedBlockTracker createTracker (boolean setCheckpointDir, org.apache.spark.util.Clock clock) { throw new RuntimeException(); }
  /** Generate blocks infos using random ids */
  public  scala.collection.Seq<org.apache.spark.streaming.scheduler.ReceivedBlockInfo> generateBlockInfos () { throw new RuntimeException(); }
  /** Get all the data written in the given write ahead log file. */
  public  scala.collection.Seq<org.apache.spark.streaming.scheduler.ReceivedBlockTrackerLogEvent> getWrittenLogData (java.lang.String logFile) { throw new RuntimeException(); }
  /**
   * Get all the data written in the given write ahead log files. By default, it will read all
   * files in the test log directory.
   */
  public  scala.collection.Seq<org.apache.spark.streaming.scheduler.ReceivedBlockTrackerLogEvent> getWrittenLogData (scala.collection.Seq<java.lang.String> logFiles) { throw new RuntimeException(); }
  /** Get all the write ahead log files in the test directory */
  public  scala.collection.Seq<java.lang.String> getWriteAheadLogFiles () { throw new RuntimeException(); }
  /** Create batch allocation object from the given info */
  public  org.apache.spark.streaming.scheduler.BatchAllocationEvent createBatchAllocation (long time, scala.collection.Seq<org.apache.spark.streaming.scheduler.ReceivedBlockInfo> blockInfos) { throw new RuntimeException(); }
  /** Create batch cleanup object from the given info */
  public  org.apache.spark.streaming.scheduler.BatchCleanupEvent createBatchCleanup (long time, scala.collection.Seq<java.lang.Object> moreTimes) { throw new RuntimeException(); }
  public  org.apache.spark.streaming.Time millisToTime (long milliseconds) { throw new RuntimeException(); }
  public  long timeToMillis (org.apache.spark.streaming.Time time) { throw new RuntimeException(); }
}
