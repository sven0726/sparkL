package org.apache.spark.streaming.kafka;
/**
 * A batch-oriented interface for consuming from Kafka.
 * Starting and ending offsets are specified in advance,
 * so that you can control exactly-once semantics.
 * @param kafkaParams Kafka <a href="http://kafka.apache.org/documentation.html#configuration">
 * configuration parameters</a>. Requires "metadata.broker.list" or "bootstrap.servers" to be set
 * with Kafka broker(s) specified in host1:port1,host2:port2 form.
 * @param offsetRanges offset ranges that define the Kafka data belonging to this RDD
 * @param messageHandler function for translating each message into the desired type
 */
public  class KafkaRDD<K extends java.lang.Object, V extends java.lang.Object, U extends kafka.serializer.Decoder<?>, T extends kafka.serializer.Decoder<?>, R extends java.lang.Object> extends org.apache.spark.rdd.RDD<R> implements org.apache.spark.Logging, org.apache.spark.streaming.kafka.HasOffsetRanges {
  private  class KafkaRDDIterator extends org.apache.spark.util.NextIterator<R> {
    public   KafkaRDDIterator (org.apache.spark.streaming.kafka.KafkaRDDPartition part, org.apache.spark.TaskContext context) { throw new RuntimeException(); }
    public  org.apache.spark.streaming.kafka.KafkaCluster kc () { throw new RuntimeException(); }
    public  kafka.serializer.Decoder<K> keyDecoder () { throw new RuntimeException(); }
    public  kafka.serializer.Decoder<V> valueDecoder () { throw new RuntimeException(); }
    public  kafka.consumer.SimpleConsumer consumer () { throw new RuntimeException(); }
    public  long requestOffset () { throw new RuntimeException(); }
    public  scala.collection.Iterator<kafka.message.MessageAndOffset> iter () { throw new RuntimeException(); }
    private  kafka.consumer.SimpleConsumer connectLeader () { throw new RuntimeException(); }
    private  void handleFetchErr (kafka.api.FetchResponse resp) { throw new RuntimeException(); }
    private  scala.collection.Iterator<kafka.message.MessageAndOffset> fetchBatch () { throw new RuntimeException(); }
    public  void close () { throw new RuntimeException(); }
    public  R getNext () { throw new RuntimeException(); }
  }
  /**
   * @param kafkaParams Kafka <a href="http://kafka.apache.org/documentation.html#configuration">
   * configuration parameters</a>.
   *   Requires "metadata.broker.list" or "bootstrap.servers" to be set with Kafka broker(s),
   *   NOT zookeeper servers, specified in host1:port1,host2:port2 form.
   * @param fromOffsets per-topic/partition Kafka offsets defining the (inclusive)
   *  starting point of the batch
   * @param untilOffsets per-topic/partition Kafka offsets defining the (exclusive)
   *  ending point of the batch
   * @param messageHandler function for translating each message into the desired type
   */
  static public <K extends java.lang.Object, V extends java.lang.Object, U extends kafka.serializer.Decoder<?>, T extends kafka.serializer.Decoder<?>, R extends java.lang.Object> org.apache.spark.streaming.kafka.KafkaRDD<K, V, U, T, R> apply (org.apache.spark.SparkContext sc, scala.collection.immutable.Map<java.lang.String, java.lang.String> kafkaParams, scala.collection.immutable.Map<kafka.common.TopicAndPartition, java.lang.Object> fromOffsets, scala.collection.immutable.Map<kafka.common.TopicAndPartition, org.apache.spark.streaming.kafka.KafkaCluster.LeaderOffset> untilOffsets, scala.Function1<kafka.message.MessageAndMetadata<K, V>, R> messageHandler, scala.reflect.ClassTag<K> evidence$6, scala.reflect.ClassTag<V> evidence$7, scala.reflect.ClassTag<U> evidence$8, scala.reflect.ClassTag<T> evidence$9, scala.reflect.ClassTag<R> evidence$10) { throw new RuntimeException(); }
  public  org.apache.spark.streaming.kafka.OffsetRange[] offsetRanges () { throw new RuntimeException(); }
  // not preceding
  public   KafkaRDD (org.apache.spark.SparkContext sc, scala.collection.immutable.Map<java.lang.String, java.lang.String> kafkaParams, org.apache.spark.streaming.kafka.OffsetRange[] offsetRanges, scala.collection.immutable.Map<kafka.common.TopicAndPartition, scala.Tuple2<java.lang.String, java.lang.Object>> leaders, scala.Function1<kafka.message.MessageAndMetadata<K, V>, R> messageHandler, scala.reflect.ClassTag<K> evidence$1, scala.reflect.ClassTag<V> evidence$2, scala.reflect.ClassTag<U> evidence$3, scala.reflect.ClassTag<T> evidence$4, scala.reflect.ClassTag<R> evidence$5) { throw new RuntimeException(); }
  public  org.apache.spark.Partition[] getPartitions () { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> getPreferredLocations (org.apache.spark.Partition thePart) { throw new RuntimeException(); }
  private  java.lang.String errBeginAfterEnd (org.apache.spark.streaming.kafka.KafkaRDDPartition part) { throw new RuntimeException(); }
  private  java.lang.String errRanOutBeforeEnd (org.apache.spark.streaming.kafka.KafkaRDDPartition part) { throw new RuntimeException(); }
  private  java.lang.String errOvershotEnd (long itemOffset, org.apache.spark.streaming.kafka.KafkaRDDPartition part) { throw new RuntimeException(); }
  public  scala.collection.Iterator<R> compute (org.apache.spark.Partition thePart, org.apache.spark.TaskContext context) { throw new RuntimeException(); }
}
