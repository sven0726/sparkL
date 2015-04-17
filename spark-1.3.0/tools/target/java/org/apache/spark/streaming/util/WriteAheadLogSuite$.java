package org.apache.spark.streaming.util;
// no position
public  class WriteAheadLogSuite$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final WriteAheadLogSuite$ MODULE$ = null;
  public   WriteAheadLogSuite$ () { throw new RuntimeException(); }
  private  org.apache.hadoop.conf.Configuration hadoopConf () { throw new RuntimeException(); }
  /** Write data to a file directly and return an array of the file segments written. */
  public  scala.collection.Seq<org.apache.spark.streaming.util.WriteAheadLogFileSegment> writeDataManually (scala.collection.Seq<java.lang.String> data, java.lang.String file) { throw new RuntimeException(); }
  /**
   * Write data to a file using the writer class and return an array of the file segments written.
   */
  public  scala.collection.Seq<org.apache.spark.streaming.util.WriteAheadLogFileSegment> writeDataUsingWriter (java.lang.String filePath, scala.collection.Seq<java.lang.String> data) { throw new RuntimeException(); }
  /** Write data to rotating files in log directory using the manager class. */
  public  org.apache.spark.streaming.util.WriteAheadLogManager writeDataUsingManager (java.lang.String logDirectory, scala.collection.Seq<java.lang.String> data, org.apache.spark.util.ManualClock manualClock, boolean stopManager) { throw new RuntimeException(); }
  /** Read data from a segments of a log file directly and return the list of byte buffers.*/
  public  scala.collection.Seq<java.lang.String> readDataManually (scala.collection.Seq<org.apache.spark.streaming.util.WriteAheadLogFileSegment> segments) { throw new RuntimeException(); }
  /** Read all the data from a log file directly and return the list of byte buffers. */
  public  scala.collection.Seq<java.lang.String> readDataManually (java.lang.String file) { throw new RuntimeException(); }
  /** Read all the data from a log file using reader class and return the list of byte buffers. */
  public  scala.collection.Seq<java.lang.String> readDataUsingReader (java.lang.String file) { throw new RuntimeException(); }
  /** Read all the data in the log file in a directory using the manager class. */
  public  scala.collection.Seq<java.lang.String> readDataUsingManager (java.lang.String logDirectory) { throw new RuntimeException(); }
  /** Get the log files in a direction */
  public  scala.collection.Seq<java.lang.String> getLogFilesInDirectory (java.lang.String directory) { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> generateRandomData () { throw new RuntimeException(); }
  public  java.nio.ByteBuffer stringToByteBuffer (java.lang.String str) { throw new RuntimeException(); }
  public  java.lang.String byteBufferToString (java.nio.ByteBuffer byteBuffer) { throw new RuntimeException(); }
}
