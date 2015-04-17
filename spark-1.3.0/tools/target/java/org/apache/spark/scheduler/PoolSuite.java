package org.apache.spark.scheduler;
/**
 * Tests that pools and the associated scheduling algorithms for FIFO and fair scheduling work
 * correctly.
 */
public  class PoolSuite extends org.scalatest.FunSuite implements org.apache.spark.LocalSparkContext {
  public   PoolSuite () { throw new RuntimeException(); }
  public  org.apache.spark.scheduler.TaskSetManager createTaskSetManager (int stageId, int numTasks, org.apache.spark.scheduler.TaskSchedulerImpl taskScheduler) { throw new RuntimeException(); }
  public  void scheduleTaskAndVerifyId (int taskId, org.apache.spark.scheduler.Pool rootPool, int expectedStageId) { throw new RuntimeException(); }
}
