package org.apache.spark;
/**
 SparkConf &#x53ea;&#x6709;&#x4e00;&#x4e2a;&#x7c7b;&#x578b;&#x4e3a;ConcurrentHashMap&#x7684;&#x5c5e;&#x6027;&#xff1a; settings&#x3002;
 &#x53ef;&#x4ee5;&#x8bbe;&#x7f6e;&#x548c;&#x5220;&#x9664;&#x5176;&#x4ed6;&#x7684;map&#x7c7b;&#x578b;&#x7684;&#x5c5e;&#x6027;
 */
public  class SparkConf implements scala.Cloneable, org.apache.spark.Logging {
  /**
   * Holds information about keys that have been deprecated or renamed.
   * <p>
   * @param oldName Old configuration key.
   * @param newName New configuration key, or <code>null</code> if key has no replacement, in which case the
   *                deprecated key will be used (but the warning message will still be printed).
   * @param version Version of Spark where key was deprecated.
   * @param deprecationMessage Message to include in the deprecation warning; mandatory when
   *                           <code>newName</code> is not provided.
   */
  static private  class DeprecatedConfig implements scala.Product, scala.Serializable {
    public  java.lang.String oldName () { throw new RuntimeException(); }
    public  java.lang.String _newName () { throw new RuntimeException(); }
    public  java.lang.String version () { throw new RuntimeException(); }
    public  java.lang.String deprecationMessage () { throw new RuntimeException(); }
    // not preceding
    public   DeprecatedConfig (java.lang.String oldName, java.lang.String _newName, java.lang.String version, java.lang.String deprecationMessage) { throw new RuntimeException(); }
    private  java.util.concurrent.atomic.AtomicBoolean warned () { throw new RuntimeException(); }
    public  scala.Option<java.lang.String> newName () { throw new RuntimeException(); }
    public  void warn () { throw new RuntimeException(); }
  }
  // no position
  static private  class DeprecatedConfig$ extends scala.runtime.AbstractFunction4<java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.apache.spark.SparkConf.DeprecatedConfig> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final DeprecatedConfig$ MODULE$ = null;
    public   DeprecatedConfig$ () { throw new RuntimeException(); }
  }
  static private  scala.collection.immutable.Map<java.lang.String, org.apache.spark.SparkConf.DeprecatedConfig> deprecatedConfigs () { throw new RuntimeException(); }
  /**
   * Return whether the given config is an akka config (e.g. akka.actor.provider).
   * Note that this does not include spark-specific akka configs (e.g. spark.akka.timeout).
   */
  static public  boolean isAkkaConf (java.lang.String name) { throw new RuntimeException(); }
  /**
   * Return whether the given config should be passed to an executor on start-up.
   * <p>
   * Certain akka and authentication configs are required of the executor when it connects to
   * the scheduler, while the rest of the spark configs can be inherited from the driver later.
   */
  static public  boolean isExecutorStartupConf (java.lang.String name) { throw new RuntimeException(); }
  /**
   * Return true if the given config matches either <code>spark.*.port</code> or <code>spark.port.*</code>.
   */
  static public  boolean isSparkPortConf (java.lang.String name) { throw new RuntimeException(); }
  /**
   * Translate the configuration key if it is deprecated and has a replacement, otherwise just
   * returns the provided key.
   * <p>
   * @param userKey Configuration key from the user / caller.
   * @param warn Whether to print a warning if the key is deprecated. Warnings will be printed
   *             only once for each key.
   */
  static public  java.lang.String translateConfKey (java.lang.String userKey, boolean warn) { throw new RuntimeException(); }
  public   SparkConf (boolean loadDefaults) { throw new RuntimeException(); }
  /** Create a SparkConf that loads defaults from system properties and the classpath */
  public   SparkConf () { throw new RuntimeException(); }
  private  java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> settings () { throw new RuntimeException(); }
  /** Set a configuration variable. */
  public  org.apache.spark.SparkConf set (java.lang.String key, java.lang.String value) { throw new RuntimeException(); }
  /**
   * The master URL to connect to, such as "local" to run locally with one thread, "local[4]" to
   * run locally with 4 cores, or "spark://master:7077" to run on a Spark standalone cluster.
   */
  public  org.apache.spark.SparkConf setMaster (java.lang.String master) { throw new RuntimeException(); }
  /** Set a name for your application. Shown in the Spark web UI. */
  public  org.apache.spark.SparkConf setAppName (java.lang.String name) { throw new RuntimeException(); }
  /** Set JAR files to distribute to the cluster. */
  public  org.apache.spark.SparkConf setJars (scala.collection.Seq<java.lang.String> jars) { throw new RuntimeException(); }
  /** Set JAR files to distribute to the cluster. (Java-friendly version.) */
  public  org.apache.spark.SparkConf setJars (java.lang.String[] jars) { throw new RuntimeException(); }
  /**
   * Set an environment variable to be used when launching executors for this application.
   * These variables are stored as properties of the form spark.executorEnv.VAR_NAME
   * (for example spark.executorEnv.PATH) but this method makes them easier to set.
   */
  public  org.apache.spark.SparkConf setExecutorEnv (java.lang.String variable, java.lang.String value) { throw new RuntimeException(); }
  /**
   * Set multiple environment variables to be used when launching executors.
   * These variables are stored as properties of the form spark.executorEnv.VAR_NAME
   * (for example spark.executorEnv.PATH) but this method makes them easier to set.
   */
  public  org.apache.spark.SparkConf setExecutorEnv (scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> variables) { throw new RuntimeException(); }
  /**
   * Set multiple environment variables to be used when launching executors.
   * (Java-friendly version.)
   */
  public  org.apache.spark.SparkConf setExecutorEnv (scala.Tuple2<java.lang.String, java.lang.String>[] variables) { throw new RuntimeException(); }
  /**
   * Set the location where Spark is installed on worker nodes.
   */
  public  org.apache.spark.SparkConf setSparkHome (java.lang.String home) { throw new RuntimeException(); }
  /** Set multiple parameters together */
  public  org.apache.spark.SparkConf setAll (scala.collection.Traversable<scala.Tuple2<java.lang.String, java.lang.String>> settings) { throw new RuntimeException(); }
  /** Set a parameter if it isn't already configured */
  public  org.apache.spark.SparkConf setIfMissing (java.lang.String key, java.lang.String value) { throw new RuntimeException(); }
  /**
   * Use Kryo serialization and register the given set of classes with Kryo.
   * If called multiple times, this will append the classes from all calls together.
   */
  public  org.apache.spark.SparkConf registerKryoClasses (java.lang.Class<?>[] classes) { throw new RuntimeException(); }
  /** Remove a parameter from the configuration */
  public  org.apache.spark.SparkConf remove (java.lang.String key) { throw new RuntimeException(); }
  /** Get a parameter; throws a NoSuchElementException if it's not set */
  public  java.lang.String get (java.lang.String key) { throw new RuntimeException(); }
  /** Get a parameter, falling back to a default if not set */
  public  java.lang.String get (java.lang.String key, java.lang.String defaultValue) { throw new RuntimeException(); }
  /** Get a parameter as an Option */
  public  scala.Option<java.lang.String> getOption (java.lang.String key) { throw new RuntimeException(); }
  /** Get all parameters as a list of pairs */
  public  scala.Tuple2<java.lang.String, java.lang.String>[] getAll () { throw new RuntimeException(); }
  /** Get a parameter as an integer, falling back to a default if not set */
  public  int getInt (java.lang.String key, int defaultValue) { throw new RuntimeException(); }
  /** Get a parameter as a long, falling back to a default if not set */
  public  long getLong (java.lang.String key, long defaultValue) { throw new RuntimeException(); }
  /** Get a parameter as a double, falling back to a default if not set */
  public  double getDouble (java.lang.String key, double defaultValue) { throw new RuntimeException(); }
  /** Get a parameter as a boolean, falling back to a default if not set */
  public  boolean getBoolean (java.lang.String key, boolean defaultValue) { throw new RuntimeException(); }
  /** Get all executor environment variables set on this SparkConf */
  public  scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> getExecutorEnv () { throw new RuntimeException(); }
  /** Get all akka conf variables set on this SparkConf */
  public  scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> getAkkaConf () { throw new RuntimeException(); }
  /**
   * Returns the Spark application id, valid in the Driver after TaskScheduler registration and
   * from the start in the Executor.
   */
  public  java.lang.String getAppId () { throw new RuntimeException(); }
  /** Does the configuration contain a given parameter? */
  public  boolean contains (java.lang.String key) { throw new RuntimeException(); }
  /** Copy this object */
  public  org.apache.spark.SparkConf clone () { throw new RuntimeException(); }
  /**
   * By using this instead of System.getenv(), environment variables can be mocked
   * in unit tests.
   */
  public  java.lang.String getenv (java.lang.String name) { throw new RuntimeException(); }
  /** Checks for illegal or deprecated config settings. Throws an exception for the former. Not
   * idempotent - may mutate this conf object to convert deprecated settings to supported ones. */
  public  void validateSettings () { throw new RuntimeException(); }
  /**
   * Return a string listing all keys and values, one per line. This is useful to print the
   * configuration out for debugging.
   */
  public  java.lang.String toDebugString () { throw new RuntimeException(); }
}
