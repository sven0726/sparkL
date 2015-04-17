package org.apache.spark.deploy.rest;
/**
 * A {@link StandaloneRestServer} that is faulty in many ways.
 * <p>
 * When handling a submit request, the server returns a malformed JSON.
 * When handling a kill request, the server returns an invalid JSON.
 * When handling a status request, the server throws an internal exception.
 * The purpose of this class is to test that client handles these cases gracefully.
 */
public  class FaultyStandaloneRestServer extends org.apache.spark.deploy.rest.StandaloneRestServer {
  public   FaultyStandaloneRestServer (java.lang.String host, int requestedPort, akka.actor.ActorRef masterActor, java.lang.String masterUrl, org.apache.spark.SparkConf masterConf) { throw new RuntimeException(); }
  protected  scala.collection.immutable.Map<java.lang.String, org.apache.spark.deploy.rest.StandaloneRestServlet> contextToServlet () { throw new RuntimeException(); }
  /** A faulty servlet that produces malformed responses. */
  public  class MalformedSubmitServlet extends org.apache.spark.deploy.rest.SubmitRequestServlet {
    public   MalformedSubmitServlet () { throw new RuntimeException(); }
    protected  void sendResponse (org.apache.spark.deploy.rest.SubmitRestProtocolResponse responseMessage, javax.servlet.http.HttpServletResponse responseServlet) { throw new RuntimeException(); }
  }
  /** A faulty servlet that produces invalid responses. */
  public  class InvalidKillServlet extends org.apache.spark.deploy.rest.KillRequestServlet {
    public   InvalidKillServlet () { throw new RuntimeException(); }
    protected  org.apache.spark.deploy.rest.KillSubmissionResponse handleKill (java.lang.String submissionId) { throw new RuntimeException(); }
  }
  /** A faulty status servlet that explodes. */
  public  class ExplodingStatusServlet extends org.apache.spark.deploy.rest.StatusRequestServlet {
    public   ExplodingStatusServlet () { throw new RuntimeException(); }
    private  int explode () { throw new RuntimeException(); }
    protected  org.apache.spark.deploy.rest.SubmissionStatusResponse handleStatus (java.lang.String submissionId) { throw new RuntimeException(); }
  }
}
