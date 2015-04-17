package org.apache.spark.executor;
/**
 * :: DeveloperApi ::
 * Metrics tracked during the execution of a task.
 * <p>
 * This class is used to house metrics both for in-progress and completed tasks. In executors,
 * both the task thread and the heartbeat thread write to the TaskMetrics. The heartbeat thread
 * reads it to send in-progress metrics, and the task thread reads it to send metrics along with
 * the completed task.
 * <p>
 * So, when adding new fields, take into consideration that the whole object can be serialized for
 * shipping off at any time to consumers of the SparkListener interface.
 */
public  class TaskMetrics implements scala.Serializable {
  static public  org.apache.spark.executor.TaskMetrics empty () { throw new RuntimeException(); }
  public   TaskMetrics () { throw new RuntimeException(); }
  /**
   * Host's name the task runs on
   */
  private  java.lang.String _hostname () { throw new RuntimeException(); }
  public  java.lang.String hostname () { throw new RuntimeException(); }
  public  void setHostname (java.lang.String value) { throw new RuntimeException(); }
  /**
   * Time taken on the executor to deserialize this task
   */
  private  long _executorDeserializeTime () { throw new RuntimeException(); }
  public  long executorDeserializeTime () { throw new RuntimeException(); }
  public  void setExecutorDeserializeTime (long value) { throw new RuntimeException(); }
  /**
   * Time the executor spends actually running the task (including fetching shuffle data)
   */
  private  long _executorRunTime () { throw new RuntimeException(); }
  public  long executorRunTime () { throw new RuntimeException(); }
  public  void setExecutorRunTime (long value) { throw new RuntimeException(); }
  /**
   * The number of bytes this task transmitted back to the driver as the TaskResult
   */
  private  long _resultSize () { throw new RuntimeException(); }
  public  long resultSize () { throw new RuntimeException(); }
  public  void setResultSize (long value) { throw new RuntimeException(); }
  /**
   * Amount of time the JVM spent in garbage collection while executing this task
   */
  private  long _jvmGCTime () { throw new RuntimeException(); }
  public  long jvmGCTime () { throw new RuntimeException(); }
  public  void setJvmGCTime (long value) { throw new RuntimeException(); }
  /**
   * Amount of time spent serializing the task result
   */
  private  long _resultSerializationTime () { throw new RuntimeException(); }
  public  long resultSerializationTime () { throw new RuntimeException(); }
  public  void setResultSerializationTime (long value) { throw new RuntimeException(); }
  /**
   * The number of in-memory bytes spilled by this task
   */
  private  long _memoryBytesSpilled () { throw new RuntimeException(); }
  public  long memoryBytesSpilled () { throw new RuntimeException(); }
  public  void incMemoryBytesSpilled (long value) { throw new RuntimeException(); }
  public  void decMemoryBytesSpilled (long value) { throw new RuntimeException(); }
  /**
   * The number of on-disk bytes spilled by this task
   */
  private  long _diskBytesSpilled () { throw new RuntimeException(); }
  public  long diskBytesSpilled () { throw new RuntimeException(); }
  public  void incDiskBytesSpilled (long value) { throw new RuntimeException(); }
  public  void decDiskBytesSpilled (long value) { throw new RuntimeException(); }
  /**
   * If this task reads from a HadoopRDD or from persisted data, metrics on how much data was read
   * are stored here.
   */
  private  scala.Option<org.apache.spark.executor.InputMetrics> _inputMetrics () { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.executor.InputMetrics> inputMetrics () { throw new RuntimeException(); }
  /**
   * This should only be used when recreating TaskMetrics, not when updating input metrics in
   * executors
   */
  public  void setInputMetrics (scala.Option<org.apache.spark.executor.InputMetrics> inputMetrics) { throw new RuntimeException(); }
  /**
   * If this task writes data externally (e.g. to a distributed filesystem), metrics on how much
   * data was written are stored here.
   */
  public  scala.Option<org.apache.spark.executor.OutputMetrics> outputMetrics () { throw new RuntimeException(); }
  /**
   * If this task reads from shuffle output, metrics on getting shuffle data will be collected here.
   * This includes read metrics aggregated over all the task's shuffle dependencies.
   */
  private  scala.Option<org.apache.spark.executor.ShuffleReadMetrics> _shuffleReadMetrics () { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.executor.ShuffleReadMetrics> shuffleReadMetrics () { throw new RuntimeException(); }
  /**
   * This should only be used when recreating TaskMetrics, not when updating read metrics in
   * executors.
   */
  public  void setShuffleReadMetrics (scala.Option<org.apache.spark.executor.ShuffleReadMetrics> shuffleReadMetrics) { throw new RuntimeException(); }
  /**
   * ShuffleReadMetrics per dependency for collecting independently while task is in progress.
   */
  private  scala.collection.mutable.ArrayBuffer<org.apache.spark.executor.ShuffleReadMetrics> depsShuffleReadMetrics () { throw new RuntimeException(); }
  /**
   * If this task writes to shuffle output, metrics on the written shuffle data will be collected
   * here
   */
  public  scala.Option<org.apache.spark.executor.ShuffleWriteMetrics> shuffleWriteMetrics () { throw new RuntimeException(); }
  /**
   * Storage statuses of any blocks that have been updated as a result of this task.
   */
  public  scala.Option<scala.collection.Seq<scala.Tuple2<org.apache.spark.storage.BlockId, org.apache.spark.storage.BlockStatus>>> updatedBlocks () { throw new RuntimeException(); }
  /**
   * A task may have multiple shuffle readers for multiple dependencies. To avoid synchronization
   * issues from readers in different threads, in-progress tasks use a ShuffleReadMetrics for each
   * dependency, and merge these metrics before reporting them to the driver. This method returns
   * a ShuffleReadMetrics for a dependency and registers it for merging later.
   */
  public  org.apache.spark.executor.ShuffleReadMetrics createShuffleReadMetricsForDependency () { throw new RuntimeException(); }
  /**
   * Returns the input metrics object that the task should use. Currently, if
   * there exists an input metric with the same readMethod, we return that one
   * so the caller can accumulate bytes read. If the readMethod is different
   * than previously seen by this task, we return a new InputMetric but don't
   * record it.
   * <p>
   * Once https://issues.apache.org/jira/browse/SPARK-5225 is addressed,
   * we can store all the different inputMetrics (one per readMethod).
   */
  public  org.apache.spark.executor.InputMetrics getInputMetricsForReadMethod (scala.Enumeration.Value readMethod) { throw new RuntimeException(); }
  /**
   * Aggregates shuffle read metrics for all registered dependencies into shuffleReadMetrics.
   */
  public  void updateShuffleReadMetrics () { throw new RuntimeException(); }
  public  void updateInputMetrics () { throw new RuntimeException(); }
}
