package org.apache.spark.executor;
/**
 * :: DeveloperApi ::
 * Metrics pertaining to shuffle data written in a given task.
 */
public  class ShuffleWriteMetrics implements scala.Serializable {
  public   ShuffleWriteMetrics () { throw new RuntimeException(); }
  /**
   * Number of bytes written for the shuffle by this task
   */
  private  long _shuffleBytesWritten () { throw new RuntimeException(); }
  public  long shuffleBytesWritten () { throw new RuntimeException(); }
  public  void incShuffleBytesWritten (long value) { throw new RuntimeException(); }
  public  void decShuffleBytesWritten (long value) { throw new RuntimeException(); }
  /**
   * Time the task spent blocking on writes to disk or buffer cache, in nanoseconds
   */
  private  long _shuffleWriteTime () { throw new RuntimeException(); }
  public  long shuffleWriteTime () { throw new RuntimeException(); }
  public  void incShuffleWriteTime (long value) { throw new RuntimeException(); }
  public  void decShuffleWriteTime (long value) { throw new RuntimeException(); }
  /**
   * Total number of records written to the shuffle by this task
   */
  private  long _shuffleRecordsWritten () { throw new RuntimeException(); }
  public  long shuffleRecordsWritten () { throw new RuntimeException(); }
  public  void incShuffleRecordsWritten (long value) { throw new RuntimeException(); }
  public  void decShuffleRecordsWritten (long value) { throw new RuntimeException(); }
  public  void setShuffleRecordsWritten (long value) { throw new RuntimeException(); }
}
