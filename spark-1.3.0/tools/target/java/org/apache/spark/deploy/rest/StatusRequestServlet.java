package org.apache.spark.deploy.rest;
/**
 * A servlet for handling status requests passed to the {@link StandaloneRestServer}.
 */
public  class StatusRequestServlet extends org.apache.spark.deploy.rest.StandaloneRestServlet {
  public   StatusRequestServlet (akka.actor.ActorRef masterActor, org.apache.spark.SparkConf conf) { throw new RuntimeException(); }
  /**
   * If a submission ID is specified in the URL, request the status of the corresponding
   * driver from the Master and include it in the response. Otherwise, return error.
   */
  protected  void doGet (javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) { throw new RuntimeException(); }
  protected  org.apache.spark.deploy.rest.SubmissionStatusResponse handleStatus (java.lang.String submissionId) { throw new RuntimeException(); }
}
