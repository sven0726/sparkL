package org.apache.spark;
// no position
public  class TaskContext$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final TaskContext$ MODULE$ = null;
  public   TaskContext$ () { throw new RuntimeException(); }
  /**
   * Return the currently active TaskContext. This can be called inside of
   * user functions to access contextual information about running tasks.
   */
  public  org.apache.spark.TaskContext get () { throw new RuntimeException(); }
  private  java.lang.ThreadLocal<org.apache.spark.TaskContext> taskContext () { throw new RuntimeException(); }
  /**
   * Set the thread local TaskContext. Internal to Spark.
   */
  protected  void setTaskContext (org.apache.spark.TaskContext tc) { throw new RuntimeException(); }
  /**
   * Unset the thread local TaskContext. Internal to Spark.
   */
  protected  void unset () { throw new RuntimeException(); }
}
