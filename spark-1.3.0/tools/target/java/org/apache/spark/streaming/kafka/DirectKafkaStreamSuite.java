package org.apache.spark.streaming.kafka;
public  class DirectKafkaStreamSuite extends org.apache.spark.streaming.kafka.KafkaStreamSuiteBase implements org.scalatest.BeforeAndAfter, org.scalatest.BeforeAndAfterAll, org.scalatest.concurrent.Eventually {
  static public  scala.collection.mutable.ArrayBuffer<java.lang.String> collectedData () { throw new RuntimeException(); }
  static public  long total () { throw new RuntimeException(); }
  public   DirectKafkaStreamSuite () { throw new RuntimeException(); }
  public  org.apache.spark.SparkConf sparkConf () { throw new RuntimeException(); }
  public  org.apache.spark.SparkContext sc () { throw new RuntimeException(); }
  public  org.apache.spark.streaming.StreamingContext ssc () { throw new RuntimeException(); }
  public  java.io.File testDir () { throw new RuntimeException(); }
  public  void beforeAll () { throw new RuntimeException(); }
  public  void afterAll () { throw new RuntimeException(); }
  /** Get the generated offset ranges from the DirectKafkaStream */
  private <K extends java.lang.Object, V extends java.lang.Object> scala.collection.Seq<scala.Tuple2<org.apache.spark.streaming.Time, org.apache.spark.streaming.kafka.OffsetRange[]>> getOffsetRanges (org.apache.spark.streaming.dstream.DStream<scala.Tuple2<K, V>> kafkaStream) { throw new RuntimeException(); }
}
