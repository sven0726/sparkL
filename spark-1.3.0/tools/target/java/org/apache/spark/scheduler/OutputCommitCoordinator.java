package org.apache.spark.scheduler;
/**
 * Authority that decides whether tasks can commit output to HDFS. Uses a "first committer wins"
 * policy.
 * <p>
 * OutputCommitCoordinator is instantiated in both the drivers and executors. On executors, it is
 * configured with a reference to the driver's OutputCommitCoordinatorActor, so requests to commit
 * output will be forwarded to the driver's OutputCommitCoordinator.
 * <p>
 * This class was introduced in SPARK-4879; see that JIRA issue (and the associated pull requests)
 * for an extensive design discussion.
 */
public  class OutputCommitCoordinator implements org.apache.spark.Logging {
  static public  class OutputCommitCoordinatorActor implements akka.actor.Actor, org.apache.spark.util.ActorLogReceive, org.apache.spark.Logging {
    public   OutputCommitCoordinatorActor (org.apache.spark.scheduler.OutputCommitCoordinator outputCommitCoordinator) { throw new RuntimeException(); }
    public  scala.PartialFunction<java.lang.Object, scala.runtime.BoxedUnit> receiveWithLogging () { throw new RuntimeException(); }
  }
  public   OutputCommitCoordinator (org.apache.spark.SparkConf conf) { throw new RuntimeException(); }
  public  scala.Option<akka.actor.ActorRef> coordinatorActor () { throw new RuntimeException(); }
  private  scala.concurrent.duration.FiniteDuration timeout () { throw new RuntimeException(); }
  private  int maxAttempts () { throw new RuntimeException(); }
  private  int retryInterval () { throw new RuntimeException(); }
  /**
   * Map from active stages's id => partition id => task attempt with exclusive lock on committing
   * output for that partition.
   * <p>
   * Entries are added to the top-level map when stages start and are removed they finish
   * (either successfully or unsuccessfully).
   * <p>
   * Access to this map should be guarded by synchronizing on the OutputCommitCoordinator instance.
   */
  private  scala.collection.mutable.Map<java.lang.Object, scala.collection.mutable.Map<java.lang.Object, java.lang.Object>> authorizedCommittersByStage () { throw new RuntimeException(); }
  /**
   * Called by tasks to ask whether they can commit their output to HDFS.
   * <p>
   * If a task attempt has been authorized to commit, then all other attempts to commit the same
   * task will be denied.  If the authorized task attempt fails (e.g. due to its executor being
   * lost), then a subsequent task attempt may be authorized to commit its output.
   * <p>
   * @param stage the stage number
   * @param partition the partition number
   * @param attempt a unique identifier for this task attempt
   * @return true if this task is authorized to commit, false otherwise
   */
  public  boolean canCommit (int stage, long partition, long attempt) { throw new RuntimeException(); }
  public  void stageStart (int stage) { throw new RuntimeException(); }
  public  void stageEnd (int stage) { throw new RuntimeException(); }
  public  void taskCompleted (int stage, long partition, long attempt, org.apache.spark.TaskEndReason reason) { throw new RuntimeException(); }
  public  void stop () { throw new RuntimeException(); }
  public  boolean handleAskPermissionToCommit (int stage, long partition, long attempt) { throw new RuntimeException(); }
}
