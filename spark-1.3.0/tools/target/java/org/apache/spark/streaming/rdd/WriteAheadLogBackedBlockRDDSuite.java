package org.apache.spark.streaming.rdd;
public  class WriteAheadLogBackedBlockRDDSuite extends org.scalatest.FunSuite implements org.scalatest.BeforeAndAfterAll, org.scalatest.BeforeAndAfterEach {
  public   WriteAheadLogBackedBlockRDDSuite () { throw new RuntimeException(); }
  public  org.apache.spark.SparkConf conf () { throw new RuntimeException(); }
  public  org.apache.hadoop.conf.Configuration hadoopConf () { throw new RuntimeException(); }
  public  org.apache.spark.SparkContext sparkContext () { throw new RuntimeException(); }
  public  org.apache.spark.storage.BlockManager blockManager () { throw new RuntimeException(); }
  public  java.io.File dir () { throw new RuntimeException(); }
  public  void beforeEach () { throw new RuntimeException(); }
  public  void afterEach () { throw new RuntimeException(); }
  public  void beforeAll () { throw new RuntimeException(); }
  public  void afterAll () { throw new RuntimeException(); }
  /**
   * Test the WriteAheadLogBackedRDD, by writing some partitions of the data to block manager
   * and the rest to a write ahead log, and then reading reading it all back using the RDD.
   * It can also test if the partitions that were read from the log were again stored in
   * block manager.
   * @param numPartitionsInBM Number of partitions to write to the Block Manager
   * @param numPartitionsInWAL Number of partitions to write to the Write Ahead Log
   * @param testStoreInBM Test whether blocks read from log are stored back into block manager
   */
  private  void testRDD (int numPartitionsInBM, int numPartitionsInWAL, boolean testStoreInBM) { throw new RuntimeException(); }
  private  scala.collection.Seq<org.apache.spark.streaming.util.WriteAheadLogFileSegment> writeLogSegments (scala.collection.Seq<scala.collection.Seq<java.lang.String>> blockData, scala.collection.Seq<org.apache.spark.storage.BlockId> blockIds) { throw new RuntimeException(); }
  private  scala.collection.Seq<org.apache.spark.streaming.util.WriteAheadLogFileSegment> generateFakeSegments (int count) { throw new RuntimeException(); }
}
