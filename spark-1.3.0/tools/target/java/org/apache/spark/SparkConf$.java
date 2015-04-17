package org.apache.spark;
// no position
public  class SparkConf$ implements org.apache.spark.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SparkConf$ MODULE$ = null;
  public   SparkConf$ () { throw new RuntimeException(); }
  private  scala.collection.immutable.Map<java.lang.String, org.apache.spark.SparkConf.DeprecatedConfig> deprecatedConfigs () { throw new RuntimeException(); }
  /**
   * Return whether the given config is an akka config (e.g. akka.actor.provider).
   * Note that this does not include spark-specific akka configs (e.g. spark.akka.timeout).
   */
  public  boolean isAkkaConf (java.lang.String name) { throw new RuntimeException(); }
  /**
   * Return whether the given config should be passed to an executor on start-up.
   * <p>
   * Certain akka and authentication configs are required of the executor when it connects to
   * the scheduler, while the rest of the spark configs can be inherited from the driver later.
   */
  public  boolean isExecutorStartupConf (java.lang.String name) { throw new RuntimeException(); }
  /**
   * Return true if the given config matches either <code>spark.*.port</code> or <code>spark.port.*</code>.
   */
  public  boolean isSparkPortConf (java.lang.String name) { throw new RuntimeException(); }
  /**
   * Translate the configuration key if it is deprecated and has a replacement, otherwise just
   * returns the provided key.
   * <p>
   * @param userKey Configuration key from the user / caller.
   * @param warn Whether to print a warning if the key is deprecated. Warnings will be printed
   *             only once for each key.
   */
  public  java.lang.String translateConfKey (java.lang.String userKey, boolean warn) { throw new RuntimeException(); }
}
