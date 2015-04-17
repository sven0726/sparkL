package org.apache.spark.scheduler.cluster;
/**
 * Grouping of data for an executor used by CoarseGrainedSchedulerBackend.
 * <p>
 * @param executorActor The ActorRef representing this executor
 * @param executorAddress The network address of this executor
 * @param executorHost The hostname that this executor is running on
 * @param freeCores  The current number of cores available for work on the executor
 * @param totalCores The total number of cores available to the executor
 */
public  class ExecutorData extends org.apache.spark.scheduler.cluster.ExecutorInfo {
  public  akka.actor.ActorRef executorActor () { throw new RuntimeException(); }
  public  akka.actor.Address executorAddress () { throw new RuntimeException(); }
  public  java.lang.String executorHost () { throw new RuntimeException(); }
  public  int freeCores () { throw new RuntimeException(); }
  public  int totalCores () { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> logUrlMap () { throw new RuntimeException(); }
  // not preceding
  public   ExecutorData (akka.actor.ActorRef executorActor, akka.actor.Address executorAddress, java.lang.String executorHost, int freeCores, int totalCores, scala.collection.immutable.Map<java.lang.String, java.lang.String> logUrlMap) { throw new RuntimeException(); }
}
