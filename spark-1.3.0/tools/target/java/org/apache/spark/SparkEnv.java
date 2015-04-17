package org.apache.spark;
/**
 *SparkEnv&#x5305;&#x542b;spark&#x4efb;&#x52a1;&#xff08;&#x5305;&#x62ec;master&#x548c;worker&#x4e0a;&#x7684;&#xff09;&#x8fd0;&#x884c;&#x65f6;&#x73af;&#x5883;&#x7684;&#x5404;&#x7c7b;&#x5bf9;&#x8c61;&#x3002;&#x5982;&#xff1a;&#x5e8f;&#x5217;&#x5316;&#x5668;&#xff0c;akka&#x7cfb;&#x7edf;&#xff0c;&#x5757;&#x7ba1;&#x7406;&#x5668;&#xff0c;map&#x8f93;&#x51fa;&#x8ddf;&#x8e2a;&#x5668;&#x3002;
 * SparkEnv&#x4e2d;&#x4e3b;&#x8981;&#x5305;&#x542b;&#x4ee5;&#x4e0b;&#x5173;&#x952e;&#x6027;&#x7ec4;&#x4ef6; 1. BlockManager 2. MapOutputTracker 3. ShuffleManager
 */
public  class SparkEnv implements org.apache.spark.Logging {
  static private  org.apache.spark.SparkEnv env () { throw new RuntimeException(); }
  static public  java.lang.String driverActorSystemName () { throw new RuntimeException(); }
  static public  java.lang.String executorActorSystemName () { throw new RuntimeException(); }
  static public  void set (org.apache.spark.SparkEnv e) { throw new RuntimeException(); }
  /**
   * Returns the SparkEnv.
   */
  static public  org.apache.spark.SparkEnv get () { throw new RuntimeException(); }
  /**
   * Returns the ThreadLocal SparkEnv.
   */
  static public  org.apache.spark.SparkEnv getThreadLocal () { throw new RuntimeException(); }
  /**
   * Create a SparkEnv for the driver.
   */
  static public  org.apache.spark.SparkEnv createDriverEnv (org.apache.spark.SparkConf conf, boolean isLocal, org.apache.spark.scheduler.LiveListenerBus listenerBus, scala.Option<org.apache.spark.scheduler.OutputCommitCoordinator> mockOutputCommitCoordinator) { throw new RuntimeException(); }
  /**
   * Create a SparkEnv for an executor.
   * In coarse-grained mode, the executor provides an actor system that is already instantiated.
   */
  static public  org.apache.spark.SparkEnv createExecutorEnv (org.apache.spark.SparkConf conf, java.lang.String executorId, java.lang.String hostname, int port, int numCores, boolean isLocal) { throw new RuntimeException(); }
  /**
   * Helper method to create a SparkEnv for a driver or an executor.
   */
  static private  org.apache.spark.SparkEnv create (org.apache.spark.SparkConf conf, java.lang.String executorId, java.lang.String hostname, int port, boolean isDriver, boolean isLocal, org.apache.spark.scheduler.LiveListenerBus listenerBus, int numUsableCores, scala.Option<org.apache.spark.scheduler.OutputCommitCoordinator> mockOutputCommitCoordinator) { throw new RuntimeException(); }
  /**
   * Return a map representation of jvm information, Spark properties, system properties, and
   * class paths. Map keys define the category, and map values represent the corresponding
   * attributes as a sequence of KV pairs. This is used mainly for SparkListenerEnvironmentUpdate.
   */
  static public  scala.collection.immutable.Map<java.lang.String, scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>>> environmentDetails (org.apache.spark.SparkConf conf, java.lang.String schedulingMode, scala.collection.Seq<java.lang.String> addedJars, scala.collection.Seq<java.lang.String> addedFiles) { throw new RuntimeException(); }
  public  java.lang.String executorId () { throw new RuntimeException(); }
  public  akka.actor.ActorSystem actorSystem () { throw new RuntimeException(); }
  public  org.apache.spark.serializer.Serializer serializer () { throw new RuntimeException(); }
  public  org.apache.spark.serializer.Serializer closureSerializer () { throw new RuntimeException(); }
  public  org.apache.spark.CacheManager cacheManager () { throw new RuntimeException(); }
  public  org.apache.spark.MapOutputTracker mapOutputTracker () { throw new RuntimeException(); }
  public  org.apache.spark.shuffle.ShuffleManager shuffleManager () { throw new RuntimeException(); }
  public  org.apache.spark.broadcast.BroadcastManager broadcastManager () { throw new RuntimeException(); }
  public  org.apache.spark.network.BlockTransferService blockTransferService () { throw new RuntimeException(); }
  public  org.apache.spark.storage.BlockManager blockManager () { throw new RuntimeException(); }
  public  org.apache.spark.SecurityManager securityManager () { throw new RuntimeException(); }
  public  org.apache.spark.HttpFileServer httpFileServer () { throw new RuntimeException(); }
  public  java.lang.String sparkFilesDir () { throw new RuntimeException(); }
  public  org.apache.spark.metrics.MetricsSystem metricsSystem () { throw new RuntimeException(); }
  public  org.apache.spark.shuffle.ShuffleMemoryManager shuffleMemoryManager () { throw new RuntimeException(); }
  public  org.apache.spark.scheduler.OutputCommitCoordinator outputCommitCoordinator () { throw new RuntimeException(); }
  public  org.apache.spark.SparkConf conf () { throw new RuntimeException(); }
  // not preceding
  public   SparkEnv (java.lang.String executorId, akka.actor.ActorSystem actorSystem, org.apache.spark.serializer.Serializer serializer, org.apache.spark.serializer.Serializer closureSerializer, org.apache.spark.CacheManager cacheManager, org.apache.spark.MapOutputTracker mapOutputTracker, org.apache.spark.shuffle.ShuffleManager shuffleManager, org.apache.spark.broadcast.BroadcastManager broadcastManager, org.apache.spark.network.BlockTransferService blockTransferService, org.apache.spark.storage.BlockManager blockManager, org.apache.spark.SecurityManager securityManager, org.apache.spark.HttpFileServer httpFileServer, java.lang.String sparkFilesDir, org.apache.spark.metrics.MetricsSystem metricsSystem, org.apache.spark.shuffle.ShuffleMemoryManager shuffleMemoryManager, org.apache.spark.scheduler.OutputCommitCoordinator outputCommitCoordinator, org.apache.spark.SparkConf conf) { throw new RuntimeException(); }
  public  boolean isStopped () { throw new RuntimeException(); }
  private  scala.collection.mutable.HashMap<scala.Tuple2<java.lang.String, scala.collection.immutable.Map<java.lang.String, java.lang.String>>, org.apache.spark.api.python.PythonWorkerFactory> pythonWorkers () { throw new RuntimeException(); }
  public  java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Object> hadoopJobMetadata () { throw new RuntimeException(); }
  public  void stop () { throw new RuntimeException(); }
  public  java.net.Socket createPythonWorker (java.lang.String pythonExec, scala.collection.immutable.Map<java.lang.String, java.lang.String> envVars) { throw new RuntimeException(); }
  public  void destroyPythonWorker (java.lang.String pythonExec, scala.collection.immutable.Map<java.lang.String, java.lang.String> envVars, java.net.Socket worker) { throw new RuntimeException(); }
  public  void releasePythonWorker (java.lang.String pythonExec, scala.collection.immutable.Map<java.lang.String, java.lang.String> envVars, java.net.Socket worker) { throw new RuntimeException(); }
}
