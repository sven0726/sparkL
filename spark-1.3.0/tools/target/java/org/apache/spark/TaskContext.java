package org.apache.spark;
/**
 * Contextual information about a task which can be read or mutated during
 * execution. To access the TaskContext for a running task, use:
 * <pre><code>
 *   org.apache.spark.TaskContext.get()
 * </code></pre>
 */
public abstract class TaskContext implements java.io.Serializable {
  /**
   * Return the currently active TaskContext. This can be called inside of
   * user functions to access contextual information about running tasks.
   */
  static public  org.apache.spark.TaskContext get () { throw new RuntimeException(); }
  static private  java.lang.ThreadLocal<org.apache.spark.TaskContext> taskContext () { throw new RuntimeException(); }
  /**
   * Set the thread local TaskContext. Internal to Spark.
   */
  static protected  void setTaskContext (org.apache.spark.TaskContext tc) { throw new RuntimeException(); }
  /**
   * Unset the thread local TaskContext. Internal to Spark.
   */
  static protected  void unset () { throw new RuntimeException(); }
  public   TaskContext () { throw new RuntimeException(); }
  /**
   * Returns true if the task has completed.
   */
  public abstract  boolean isCompleted () ;
  /**
   * Returns true if the task has been killed.
   */
  public abstract  boolean isInterrupted () ;
  public abstract  boolean runningLocally () ;
  /**
   * Returns true if the task is running locally in the driver program.
   * @return
   */
  public abstract  boolean isRunningLocally () ;
  /**
   * Adds a (Java friendly) listener to be executed on task completion.
   * This will be called in all situation - success, failure, or cancellation.
   * An example use is for HadoopRDD to register a callback to close the input stream.
   */
  public abstract  org.apache.spark.TaskContext addTaskCompletionListener (org.apache.spark.util.TaskCompletionListener listener) ;
  /**
   * Adds a listener in the form of a Scala closure to be executed on task completion.
   * This will be called in all situations - success, failure, or cancellation.
   * An example use is for HadoopRDD to register a callback to close the input stream.
   */
  public abstract  org.apache.spark.TaskContext addTaskCompletionListener (scala.Function1<org.apache.spark.TaskContext, scala.runtime.BoxedUnit> f) ;
  /**
   * Adds a callback function to be executed on task completion. An example use
   * is for HadoopRDD to register a callback to close the input stream.
   * Will be called in any situation - success, failure, or cancellation.
   * <p>
   * @param f Callback function.
   */
  public abstract  void addOnCompleteCallback (scala.Function0<scala.runtime.BoxedUnit> f) ;
  /**
   * The ID of the stage that this task belong to.
   */
  public abstract  int stageId () ;
  /**
   * The ID of the RDD partition that is computed by this task.
   */
  public abstract  int partitionId () ;
  /**
   * How many times this task has been attempted.  The first task attempt will be assigned
   * attemptNumber = 0, and subsequent attempts will have increasing attempt numbers.
   */
  public abstract  int attemptNumber () ;
  public abstract  long attemptId () ;
  /**
   * An ID that is unique to this task attempt (within the same SparkContext, no two task attempts
   * will share the same attempt ID).  This is roughly equivalent to Hadoop's TaskAttemptID.
   */
  public abstract  long taskAttemptId () ;
  /** ::DeveloperApi:: */
  public abstract  org.apache.spark.executor.TaskMetrics taskMetrics () ;
}
