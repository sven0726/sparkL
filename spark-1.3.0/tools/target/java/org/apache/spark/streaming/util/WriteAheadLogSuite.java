package org.apache.spark.streaming.util;
public  class WriteAheadLogSuite extends org.scalatest.FunSuite implements org.scalatest.BeforeAndAfter {
  /** Write data to a file directly and return an array of the file segments written. */
  static public  scala.collection.Seq<org.apache.spark.streaming.util.WriteAheadLogFileSegment> writeDataManually (scala.collection.Seq<java.lang.String> data, java.lang.String file) { throw new RuntimeException(); }
  /**
   * Write data to a file using the writer class and return an array of the file segments written.
   */
  static public  scala.collection.Seq<org.apache.spark.streaming.util.WriteAheadLogFileSegment> writeDataUsingWriter (java.lang.String filePath, scala.collection.Seq<java.lang.String> data) { throw new RuntimeException(); }
  /** Write data to rotating files in log directory using the manager class. */
  static public  org.apache.spark.streaming.util.WriteAheadLogManager writeDataUsingManager (java.lang.String logDirectory, scala.collection.Seq<java.lang.String> data, org.apache.spark.util.ManualClock manualClock, boolean stopManager) { throw new RuntimeException(); }
  /** Read data from a segments of a log file directly and return the list of byte buffers.*/
  static public  scala.collection.Seq<java.lang.String> readDataManually (scala.collection.Seq<org.apache.spark.streaming.util.WriteAheadLogFileSegment> segments) { throw new RuntimeException(); }
  /** Read all the data from a log file directly and return the list of byte buffers. */
  static public  scala.collection.Seq<java.lang.String> readDataManually (java.lang.String file) { throw new RuntimeException(); }
  /** Read all the data from a log file using reader class and return the list of byte buffers. */
  static public  scala.collection.Seq<java.lang.String> readDataUsingReader (java.lang.String file) { throw new RuntimeException(); }
  /** Read all the data in the log file in a directory using the manager class. */
  static public  scala.collection.Seq<java.lang.String> readDataUsingManager (java.lang.String logDirectory) { throw new RuntimeException(); }
  /** Get the log files in a direction */
  static public  scala.collection.Seq<java.lang.String> getLogFilesInDirectory (java.lang.String directory) { throw new RuntimeException(); }
  static public  scala.collection.Seq<java.lang.String> generateRandomData () { throw new RuntimeException(); }
  static public  java.nio.ByteBuffer stringToByteBuffer (java.lang.String str) { throw new RuntimeException(); }
  static public  java.lang.String byteBufferToString (java.nio.ByteBuffer byteBuffer) { throw new RuntimeException(); }
  public   WriteAheadLogSuite () { throw new RuntimeException(); }
  public  org.apache.hadoop.conf.Configuration hadoopConf () { throw new RuntimeException(); }
  public  java.io.File tempDir () { throw new RuntimeException(); }
  public  java.lang.String testDir () { throw new RuntimeException(); }
  public  java.lang.String testFile () { throw new RuntimeException(); }
  public  org.apache.spark.streaming.util.WriteAheadLogManager manager () { throw new RuntimeException(); }
  private  void logCleanUpTest (boolean waitForCompletion) { throw new RuntimeException(); }
}
