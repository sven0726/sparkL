package org.apache.spark.streaming.kafka;
/**
 * This is a helper class that wraps the KafkaUtils.createStream() into more
 * Python-friendly class and function so that it can be easily
 * instantiated and called from Python's KafkaUtils (see SPARK-6027).
 * <p>
 * The zero-arg constructor helps instantiate this class from the Class object
 * classOf[KafkaUtilsPythonHelper].newInstance(), and the createStream()
 * takes care of known parameters instead of passing them from Python
 */
public  class KafkaUtilsPythonHelper {
  public   KafkaUtilsPythonHelper () { throw new RuntimeException(); }
  public  org.apache.spark.streaming.api.java.JavaPairReceiverInputDStream<byte[], byte[]> createStream (org.apache.spark.streaming.api.java.JavaStreamingContext jssc, java.util.Map<java.lang.String, java.lang.String> kafkaParams, java.util.Map<java.lang.String, java.lang.Integer> topics, org.apache.spark.storage.StorageLevel storageLevel) { throw new RuntimeException(); }
}
