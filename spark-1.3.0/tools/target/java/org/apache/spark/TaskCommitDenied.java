package org.apache.spark;
/**
 * :: DeveloperApi ::
 * Task requested the driver to commit, but was denied.
 */
public  class TaskCommitDenied implements org.apache.spark.TaskFailedReason, scala.Product, scala.Serializable {
  public  int jobID () { throw new RuntimeException(); }
  public  int partitionID () { throw new RuntimeException(); }
  public  int attemptID () { throw new RuntimeException(); }
  // not preceding
  public   TaskCommitDenied (int jobID, int partitionID, int attemptID) { throw new RuntimeException(); }
  public  java.lang.String toErrorString () { throw new RuntimeException(); }
}
