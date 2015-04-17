package org.apache.spark.streaming.mqtt;
// no position
public  class MQTTUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final MQTTUtils$ MODULE$ = null;
  public   MQTTUtils$ () { throw new RuntimeException(); }
  /**
   * Create an input stream that receives messages pushed by a MQTT publisher.
   * @param ssc           StreamingContext object
   * @param brokerUrl     Url of remote MQTT publisher
   * @param topic         Topic name to subscribe to
   * @param storageLevel  RDD storage level. Defaults to StorageLevel.MEMORY_AND_DISK_SER_2.
   */
  public  org.apache.spark.streaming.dstream.ReceiverInputDStream<java.lang.String> createStream (org.apache.spark.streaming.StreamingContext ssc, java.lang.String brokerUrl, java.lang.String topic, org.apache.spark.storage.StorageLevel storageLevel) { throw new RuntimeException(); }
  /**
   * Create an input stream that receives messages pushed by a MQTT publisher.
   * Storage level of the data will be the default StorageLevel.MEMORY_AND_DISK_SER_2.
   * @param jssc      JavaStreamingContext object
   * @param brokerUrl Url of remote MQTT publisher
   * @param topic     Topic name to subscribe to
   */
  public  org.apache.spark.streaming.api.java.JavaReceiverInputDStream<java.lang.String> createStream (org.apache.spark.streaming.api.java.JavaStreamingContext jssc, java.lang.String brokerUrl, java.lang.String topic) { throw new RuntimeException(); }
  /**
   * Create an input stream that receives messages pushed by a MQTT publisher.
   * @param jssc      JavaStreamingContext object
   * @param brokerUrl     Url of remote MQTT publisher
   * @param topic         Topic name to subscribe to
   * @param storageLevel  RDD storage level.
   */
  public  org.apache.spark.streaming.api.java.JavaReceiverInputDStream<java.lang.String> createStream (org.apache.spark.streaming.api.java.JavaStreamingContext jssc, java.lang.String brokerUrl, java.lang.String topic, org.apache.spark.storage.StorageLevel storageLevel) { throw new RuntimeException(); }
}
