package org.apache.spark.deploy.rest;
/**
 * A server that responds to requests submitted by the {@link StandaloneRestClient}.
 * This is intended to be embedded in the standalone Master and used in cluster mode only.
 * <p>
 * This server responds with different HTTP codes depending on the situation:
 *   200 OK - Request was processed successfully
 *   400 BAD REQUEST - Request was malformed, not successfully validated, or of unexpected type
 *   468 UNKNOWN PROTOCOL VERSION - Request specified a protocol this server does not understand
 *   500 INTERNAL SERVER ERROR - Server throws an exception internally while processing the request
 * <p>
 * The server always includes a JSON representation of the relevant {@link SubmitRestProtocolResponse}
 * in the HTTP body. If an error occurs, however, the server will include an {@link ErrorResponse}
 * instead of the one expected by the client. If the construction of this error response itself
 * fails, the response will consist of an empty body with a response code that indicates internal
 * server error.
 * <p>
 * @param host the address this server should bind to
 * @param requestedPort the port this server will attempt to bind to
 * @param masterActor reference to the Master actor to which requests can be sent
 * @param masterUrl the URL of the Master new drivers will attempt to connect to
 * @param masterConf the conf used by the Master
 */
public  class StandaloneRestServer implements org.apache.spark.Logging {
  static public  java.lang.String PROTOCOL_VERSION () { throw new RuntimeException(); }
  static public  int SC_UNKNOWN_PROTOCOL_VERSION () { throw new RuntimeException(); }
  public   StandaloneRestServer (java.lang.String host, int requestedPort, akka.actor.ActorRef masterActor, java.lang.String masterUrl, org.apache.spark.SparkConf masterConf) { throw new RuntimeException(); }
  private  scala.Option<org.eclipse.jetty.server.Server> _server () { throw new RuntimeException(); }
  protected  java.lang.String baseContext () { throw new RuntimeException(); }
  protected  scala.collection.immutable.Map<java.lang.String, org.apache.spark.deploy.rest.StandaloneRestServlet> contextToServlet () { throw new RuntimeException(); }
  /** Start the server and return the bound port. */
  public  int start () { throw new RuntimeException(); }
  /**
   * Map the servlets to their corresponding contexts and attach them to a server.
   * Return a 2-tuple of the started server and the bound port.
   */
  private  scala.Tuple2<org.eclipse.jetty.server.Server, java.lang.Object> doStart (int startPort) { throw new RuntimeException(); }
  public  void stop () { throw new RuntimeException(); }
}
