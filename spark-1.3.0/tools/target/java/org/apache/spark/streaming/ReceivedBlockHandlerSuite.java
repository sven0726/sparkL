package org.apache.spark.streaming;
public  class ReceivedBlockHandlerSuite extends org.scalatest.FunSuite implements org.scalatest.BeforeAndAfter, org.scalatest.Matchers, org.apache.spark.Logging {
  public   ReceivedBlockHandlerSuite () { throw new RuntimeException(); }
  public  org.apache.spark.SparkConf conf () { throw new RuntimeException(); }
  public  org.apache.hadoop.conf.Configuration hadoopConf () { throw new RuntimeException(); }
  public  org.apache.spark.storage.StorageLevel storageLevel () { throw new RuntimeException(); }
  public  int streamId () { throw new RuntimeException(); }
  public  org.apache.spark.SecurityManager securityMgr () { throw new RuntimeException(); }
  public  org.apache.spark.MapOutputTrackerMaster mapOutputTracker () { throw new RuntimeException(); }
  public  org.apache.spark.shuffle.hash.HashShuffleManager shuffleManager () { throw new RuntimeException(); }
  public  org.apache.spark.serializer.KryoSerializer serializer () { throw new RuntimeException(); }
  public  org.apache.spark.util.ManualClock manualClock () { throw new RuntimeException(); }
  public  int blockManagerSize () { throw new RuntimeException(); }
  public  akka.actor.ActorSystem actorSystem () { throw new RuntimeException(); }
  public  org.apache.spark.storage.BlockManagerMaster blockManagerMaster () { throw new RuntimeException(); }
  public  org.apache.spark.storage.BlockManager blockManager () { throw new RuntimeException(); }
  public  java.io.File tempDirectory () { throw new RuntimeException(); }
  /**
   * Test storing of data using different forms of ReceivedBlocks and verify that they succeeded
   * using the given verification function
   */
  private  void testBlockStoring (org.apache.spark.streaming.receiver.ReceivedBlockHandler receivedBlockHandler, scala.Function3<scala.collection.Seq<java.lang.String>, scala.collection.Seq<org.apache.spark.storage.StreamBlockId>, scala.collection.Seq<org.apache.spark.streaming.receiver.ReceivedBlockStoreResult>, scala.runtime.BoxedUnit> verifyFunc) { throw new RuntimeException(); }
  /** Test error handling when blocks that cannot be stored */
  private  void testErrorHandling (org.apache.spark.streaming.receiver.ReceivedBlockHandler receivedBlockHandler) { throw new RuntimeException(); }
  /** Instantiate a BlockManagerBasedBlockHandler and run a code with it */
  private  void withBlockManagerBasedBlockHandler (scala.Function1<org.apache.spark.streaming.receiver.BlockManagerBasedBlockHandler, scala.runtime.BoxedUnit> body) { throw new RuntimeException(); }
  /** Instantiate a WriteAheadLogBasedBlockHandler and run a code with it */
  private  void withWriteAheadLogBasedBlockHandler (scala.Function1<org.apache.spark.streaming.receiver.WriteAheadLogBasedBlockHandler, scala.runtime.BoxedUnit> body) { throw new RuntimeException(); }
  /** Store blocks using a handler */
  private  scala.Tuple2<scala.collection.Seq<org.apache.spark.storage.StreamBlockId>, scala.collection.Seq<org.apache.spark.streaming.receiver.ReceivedBlockStoreResult>> storeBlocks (org.apache.spark.streaming.receiver.ReceivedBlockHandler receivedBlockHandler, scala.collection.Seq<org.apache.spark.streaming.receiver.ReceivedBlock> blocks) { throw new RuntimeException(); }
  private  scala.collection.Seq<java.lang.String> getWriteAheadLogFiles () { throw new RuntimeException(); }
  private  org.apache.spark.storage.StreamBlockId generateBlockId () { throw new RuntimeException(); }
}
