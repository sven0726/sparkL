package org.apache.spark.deploy.rest;
/**
 * A servlet for handling kill requests passed to the {@link StandaloneRestServer}.
 */
public  class KillRequestServlet extends org.apache.spark.deploy.rest.StandaloneRestServlet {
  public   KillRequestServlet (akka.actor.ActorRef masterActor, org.apache.spark.SparkConf conf) { throw new RuntimeException(); }
  /**
   * If a submission ID is specified in the URL, have the Master kill the corresponding
   * driver and return an appropriate response to the client. Otherwise, return error.
   */
  protected  void doPost (javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) { throw new RuntimeException(); }
  protected  org.apache.spark.deploy.rest.KillSubmissionResponse handleKill (java.lang.String submissionId) { throw new RuntimeException(); }
}
