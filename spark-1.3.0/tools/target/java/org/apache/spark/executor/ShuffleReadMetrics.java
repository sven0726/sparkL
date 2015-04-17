package org.apache.spark.executor;
/**
 * :: DeveloperApi ::
 * Metrics pertaining to shuffle data read in a given task.
 */
public  class ShuffleReadMetrics implements scala.Serializable {
  public   ShuffleReadMetrics () { throw new RuntimeException(); }
  /**
   * Number of remote blocks fetched in this shuffle by this task
   */
  private  int _remoteBlocksFetched () { throw new RuntimeException(); }
  public  int remoteBlocksFetched () { throw new RuntimeException(); }
  public  void incRemoteBlocksFetched (int value) { throw new RuntimeException(); }
  public  void decRemoteBlocksFetched (int value) { throw new RuntimeException(); }
  /**
   * Number of local blocks fetched in this shuffle by this task
   */
  private  int _localBlocksFetched () { throw new RuntimeException(); }
  public  int localBlocksFetched () { throw new RuntimeException(); }
  public  void incLocalBlocksFetched (int value) { throw new RuntimeException(); }
  public  void decLocalBlocksFetched (int value) { throw new RuntimeException(); }
  /**
   * Time the task spent waiting for remote shuffle blocks. This only includes the time
   * blocking on shuffle input data. For instance if block B is being fetched while the task is
   * still not finished processing block A, it is not considered to be blocking on block B.
   */
  private  long _fetchWaitTime () { throw new RuntimeException(); }
  public  long fetchWaitTime () { throw new RuntimeException(); }
  public  void incFetchWaitTime (long value) { throw new RuntimeException(); }
  public  void decFetchWaitTime (long value) { throw new RuntimeException(); }
  /**
   * Total number of remote bytes read from the shuffle by this task
   */
  private  long _remoteBytesRead () { throw new RuntimeException(); }
  public  long remoteBytesRead () { throw new RuntimeException(); }
  public  void incRemoteBytesRead (long value) { throw new RuntimeException(); }
  public  void decRemoteBytesRead (long value) { throw new RuntimeException(); }
  /**
   * Shuffle data that was read from the local disk (as opposed to from a remote executor).
   */
  private  long _localBytesRead () { throw new RuntimeException(); }
  public  long localBytesRead () { throw new RuntimeException(); }
  public  void incLocalBytesRead (long value) { throw new RuntimeException(); }
  /**
   * Total bytes fetched in the shuffle by this task (both remote and local).
   */
  public  long totalBytesRead () { throw new RuntimeException(); }
  /**
   * Number of blocks fetched in this shuffle by this task (remote or local)
   */
  public  int totalBlocksFetched () { throw new RuntimeException(); }
  /**
   * Total number of records read from the shuffle by this task
   */
  private  long _recordsRead () { throw new RuntimeException(); }
  public  long recordsRead () { throw new RuntimeException(); }
  public  void incRecordsRead (long value) { throw new RuntimeException(); }
  public  void decRecordsRead (long value) { throw new RuntimeException(); }
}
