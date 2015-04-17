package org.apache.spark.streaming.zeromq;
// no position
public  class ZeroMQUtils {
  /**
   * Create an input stream that receives messages pushed by a zeromq publisher.
   * @param ssc            StreamingContext object
   * @param publisherUrl   Url of remote zeromq publisher
   * @param subscribe      Topic to subscribe to
   * @param bytesToObjects A zeroMQ stream publishes sequence of frames for each topic
   *                       and each frame has sequence of byte thus it needs the converter
   *                       (which might be deserializer of bytes) to translate from sequence
   *                       of sequence of bytes, where sequence refer to a frame
   *                       and sub sequence refer to its payload.
   * @param storageLevel   RDD storage level. Defaults to StorageLevel.MEMORY_AND_DISK_SER_2.
   */
  static public <T extends java.lang.Object> org.apache.spark.streaming.dstream.ReceiverInputDStream<T> createStream (org.apache.spark.streaming.StreamingContext ssc, java.lang.String publisherUrl, akka.zeromq.Subscribe subscribe, scala.Function1<scala.collection.Seq<akka.util.ByteString>, scala.collection.Iterator<T>> bytesToObjects, org.apache.spark.storage.StorageLevel storageLevel, akka.actor.SupervisorStrategy supervisorStrategy, scala.reflect.ClassTag<T> evidence$1) { throw new RuntimeException(); }
  /**
   * Create an input stream that receives messages pushed by a zeromq publisher.
   * @param jssc           JavaStreamingContext object
   * @param publisherUrl   Url of remote ZeroMQ publisher
   * @param subscribe      Topic to subscribe to
   * @param bytesToObjects A zeroMQ stream publishes sequence of frames for each topic and each
   *                       frame has sequence of byte thus it needs the converter(which might be
   *                       deserializer of bytes) to translate from sequence of sequence of bytes,
   *                       where sequence refer to a frame and sub sequence refer to its payload.
   * @param storageLevel  Storage level to use for storing the received objects
   */
  static public <T extends java.lang.Object> org.apache.spark.streaming.api.java.JavaReceiverInputDStream<T> createStream (org.apache.spark.streaming.api.java.JavaStreamingContext jssc, java.lang.String publisherUrl, akka.zeromq.Subscribe subscribe, org.apache.spark.api.java.function.Function<byte[][], java.lang.Iterable<T>> bytesToObjects, org.apache.spark.storage.StorageLevel storageLevel, akka.actor.SupervisorStrategy supervisorStrategy) { throw new RuntimeException(); }
  /**
   * Create an input stream that receives messages pushed by a zeromq publisher.
   * @param jssc           JavaStreamingContext object
   * @param publisherUrl   Url of remote zeromq publisher
   * @param subscribe      Topic to subscribe to
   * @param bytesToObjects A zeroMQ stream publishes sequence of frames for each topic and each
   *                       frame has sequence of byte thus it needs the converter(which might be
   *                       deserializer of bytes) to translate from sequence of sequence of bytes,
   *                       where sequence refer to a frame and sub sequence refer to its payload.
   * @param storageLevel   RDD storage level.
   */
  static public <T extends java.lang.Object> org.apache.spark.streaming.api.java.JavaReceiverInputDStream<T> createStream (org.apache.spark.streaming.api.java.JavaStreamingContext jssc, java.lang.String publisherUrl, akka.zeromq.Subscribe subscribe, org.apache.spark.api.java.function.Function<byte[][], java.lang.Iterable<T>> bytesToObjects, org.apache.spark.storage.StorageLevel storageLevel) { throw new RuntimeException(); }
  /**
   * Create an input stream that receives messages pushed by a zeromq publisher.
   * @param jssc           JavaStreamingContext object
   * @param publisherUrl   Url of remote zeromq publisher
   * @param subscribe      Topic to subscribe to
   * @param bytesToObjects A zeroMQ stream publishes sequence of frames for each topic and each
   *                       frame has sequence of byte thus it needs the converter(which might
   *                       be deserializer of bytes) to translate from sequence of sequence of
   *                       bytes, where sequence refer to a frame and sub sequence refer to its
   *                       payload.
   */
  static public <T extends java.lang.Object> org.apache.spark.streaming.api.java.JavaReceiverInputDStream<T> createStream (org.apache.spark.streaming.api.java.JavaStreamingContext jssc, java.lang.String publisherUrl, akka.zeromq.Subscribe subscribe, org.apache.spark.api.java.function.Function<byte[][], java.lang.Iterable<T>> bytesToObjects) { throw new RuntimeException(); }
}
