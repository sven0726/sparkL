package org.apache.spark.streaming.kafka;
public  class ReliableKafkaStreamSuite extends org.apache.spark.streaming.kafka.KafkaStreamSuiteBase implements org.scalatest.BeforeAndAfter, org.scalatest.concurrent.Eventually {
  public   ReliableKafkaStreamSuite () { throw new RuntimeException(); }
  public  org.apache.spark.SparkConf sparkConf () { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.Object> data () { throw new RuntimeException(); }
  public  java.lang.String groupId () { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> kafkaParams () { throw new RuntimeException(); }
  public  org.apache.spark.streaming.StreamingContext ssc () { throw new RuntimeException(); }
  public  java.io.File tempDirectory () { throw new RuntimeException(); }
  /** Getting partition offset from Zookeeper. */
  private  scala.Option<java.lang.Object> getCommitOffset (java.lang.String groupId, java.lang.String topic, int partition) { throw new RuntimeException(); }
}
