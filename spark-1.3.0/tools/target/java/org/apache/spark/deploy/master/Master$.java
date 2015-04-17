package org.apache.spark.deploy.master;
// no position
public  class Master$ implements org.apache.spark.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final Master$ MODULE$ = null;
  public   Master$ () { throw new RuntimeException(); }
  public  java.lang.String systemName () { throw new RuntimeException(); }
  private  java.lang.String actorName () { throw new RuntimeException(); }
  public  void main (java.lang.String[] argStrings) { throw new RuntimeException(); }
  /**
   * Returns an <code>akka.tcp://...</code> URL for the Master actor given a sparkUrl <code>spark://host:port</code>.
   * <p>
   * @throws SparkException if the url is invalid
   */
  public  java.lang.String toAkkaUrl (java.lang.String sparkUrl, java.lang.String protocol) { throw new RuntimeException(); }
  /**
   * Returns an akka <code>Address</code> for the Master actor given a sparkUrl <code>spark://host:port</code>.
   * <p>
   * @throws SparkException if the url is invalid
   */
  public  akka.actor.Address toAkkaAddress (java.lang.String sparkUrl, java.lang.String protocol) { throw new RuntimeException(); }
  /**
   * Start the Master and return a four tuple of:
   *   (1) The Master actor system
   *   (2) The bound port
   *   (3) The web UI bound port
   *   (4) The REST server bound port, if any
   */
  public  scala.Tuple4<akka.actor.ActorSystem, java.lang.Object, java.lang.Object, scala.Option<java.lang.Object>> startSystemAndActor (java.lang.String host, int port, int webUiPort, org.apache.spark.SparkConf conf) { throw new RuntimeException(); }
}
