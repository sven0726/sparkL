package org.apache.spark;
/**
 * A client that communicates with the cluster manager to request or kill executors.
 * This is currently supported only in YARN mode.
 */
public  interface ExecutorAllocationClient {
  /**
   * Express a preference to the cluster manager for a given total number of executors.
   * This can result in canceling pending requests or filing additional requests.
   * @return whether the request is acknowledged by the cluster manager.
   */
  public  boolean requestTotalExecutors (int numExecutors) ;
  /**
   * Request an additional number of executors from the cluster manager.
   * @return whether the request is acknowledged by the cluster manager.
   */
  public  boolean requestExecutors (int numAdditionalExecutors) ;
  /**
   * Request that the cluster manager kill the specified executors.
   * @return whether the request is acknowledged by the cluster manager.
   */
  public  boolean killExecutors (scala.collection.Seq<java.lang.String> executorIds) ;
  /**
   * Request that the cluster manager kill the specified executor.
   * @return whether the request is acknowledged by the cluster manager.
   */
  public  boolean killExecutor (java.lang.String executorId) ;
}
