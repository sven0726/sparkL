package org.apache.spark.deploy.rest;
/**
 * A servlet for handling submit requests passed to the {@link StandaloneRestServer}.
 */
public  class SubmitRequestServlet extends org.apache.spark.deploy.rest.StandaloneRestServlet {
  public   SubmitRequestServlet (akka.actor.ActorRef masterActor, java.lang.String masterUrl, org.apache.spark.SparkConf conf) { throw new RuntimeException(); }
  /**
   * Submit an application to the Master with parameters specified in the request.
   * <p>
   * The request is assumed to be a {@link SubmitRestProtocolRequest} in the form of JSON.
   * If the request is successfully processed, return an appropriate response to the
   * client indicating so. Otherwise, return error instead.
   */
  protected  void doPost (javax.servlet.http.HttpServletRequest requestServlet, javax.servlet.http.HttpServletResponse responseServlet) { throw new RuntimeException(); }
  /**
   * Handle the submit request and construct an appropriate response to return to the client.
   * <p>
   * This assumes that the request message is already successfully validated.
   * If the request message is not of the expected type, return error to the client.
   */
  private  org.apache.spark.deploy.rest.SubmitRestProtocolResponse handleSubmit (java.lang.String requestMessageJson, org.apache.spark.deploy.rest.SubmitRestProtocolMessage requestMessage, javax.servlet.http.HttpServletResponse responseServlet) { throw new RuntimeException(); }
  /**
   * Build a driver description from the fields specified in the submit request.
   * <p>
   * This involves constructing a command that takes into account memory, java options,
   * classpath and other settings to launch the driver. This does not currently consider
   * fields used by python applications since python is not supported in standalone
   * cluster mode yet.
   */
  private  org.apache.spark.deploy.DriverDescription buildDriverDescription (org.apache.spark.deploy.rest.CreateSubmissionRequest request) { throw new RuntimeException(); }
}
