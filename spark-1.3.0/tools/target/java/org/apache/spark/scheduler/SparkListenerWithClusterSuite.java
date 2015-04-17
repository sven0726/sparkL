package org.apache.spark.scheduler;
/**
 * Unit tests for SparkListener that require a local cluster.
 */
public  class SparkListenerWithClusterSuite extends org.scalatest.FunSuite implements org.apache.spark.LocalSparkContext, org.scalatest.BeforeAndAfter, org.scalatest.BeforeAndAfterAll {
  public   SparkListenerWithClusterSuite () { throw new RuntimeException(); }
  /** Length of time to wait while draining listener events. */
  public  int WAIT_TIMEOUT_MILLIS () { throw new RuntimeException(); }
  private  class SaveExecutorInfo implements org.apache.spark.scheduler.SparkListener {
    public   SaveExecutorInfo () { throw new RuntimeException(); }
    public  scala.collection.mutable.Map<java.lang.String, org.apache.spark.scheduler.cluster.ExecutorInfo> addedExecutorInfo () { throw new RuntimeException(); }
    public  void onExecutorAdded (org.apache.spark.scheduler.SparkListenerExecutorAdded executor) { throw new RuntimeException(); }
  }
}
