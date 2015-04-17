package org.apache.spark.deploy.rest;
// no position
public  class StandaloneRestClient$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final StandaloneRestClient$ MODULE$ = null;
  public   StandaloneRestClient$ () { throw new RuntimeException(); }
  public  int REPORT_DRIVER_STATUS_INTERVAL () { throw new RuntimeException(); }
  public  int REPORT_DRIVER_STATUS_MAX_TRIES () { throw new RuntimeException(); }
  public  java.lang.String PROTOCOL_VERSION () { throw new RuntimeException(); }
  /**
   * Submit an application, assuming Spark parameters are specified through the given config.
   * This is abstracted to its own method for testing purposes.
   */
  public  org.apache.spark.deploy.rest.SubmitRestProtocolResponse run (java.lang.String appResource, java.lang.String mainClass, java.lang.String[] appArgs, org.apache.spark.SparkConf conf, scala.collection.immutable.Map<java.lang.String, java.lang.String> env) { throw new RuntimeException(); }
  public  void main (java.lang.String[] args) { throw new RuntimeException(); }
}
