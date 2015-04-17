package org.apache.spark.streaming.kafka;
/**
 * :: Experimental ::
 * Represents a range of offsets from a single Kafka TopicAndPartition. Instances of this class
 * can be created with <code>OffsetRange.create()</code>.
 */
public final class OffsetRange implements scala.Serializable {
  static public  org.apache.spark.streaming.kafka.OffsetRange create (java.lang.String topic, int partition, long fromOffset, long untilOffset) { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.kafka.OffsetRange create (kafka.common.TopicAndPartition topicAndPartition, long fromOffset, long untilOffset) { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.kafka.OffsetRange apply (java.lang.String topic, int partition, long fromOffset, long untilOffset) { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.kafka.OffsetRange apply (kafka.common.TopicAndPartition topicAndPartition, long fromOffset, long untilOffset) { throw new RuntimeException(); }
  static public  org.apache.spark.streaming.kafka.OffsetRange apply (scala.Tuple4<java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object> t) { throw new RuntimeException(); }
  /** Kafka topic name */
  public  java.lang.String topic () { throw new RuntimeException(); }
  /** Kafka partition id */
  public  int partition () { throw new RuntimeException(); }
  /** inclusive starting offset */
  public  long fromOffset () { throw new RuntimeException(); }
  /** exclusive ending offset */
  public  long untilOffset () { throw new RuntimeException(); }
  // not preceding
  private   OffsetRange (java.lang.String topic, int partition, long fromOffset, long untilOffset) { throw new RuntimeException(); }
  /** exclusive ending offset */
  public  boolean equals (Object obj) { throw new RuntimeException(); }
  public  int hashCode () { throw new RuntimeException(); }
  public  java.lang.String toString () { throw new RuntimeException(); }
  /** this is to avoid ClassNotFoundException during checkpoint restore */
  public  scala.Tuple4<java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object> toTuple () { throw new RuntimeException(); }
}
