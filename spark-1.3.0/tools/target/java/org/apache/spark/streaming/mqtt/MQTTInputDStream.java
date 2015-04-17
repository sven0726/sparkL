package org.apache.spark.streaming.mqtt;
/**
 * Input stream that subscribe messages from a Mqtt Broker.
 * Uses eclipse paho as MqttClient http://www.eclipse.org/paho/
 * @param brokerUrl Url of remote mqtt publisher
 * @param topic topic name to subscribe to
 * @param storageLevel RDD storage level.
 */
public  class MQTTInputDStream extends org.apache.spark.streaming.dstream.ReceiverInputDStream<java.lang.String> {
  public   MQTTInputDStream (org.apache.spark.streaming.StreamingContext ssc_, java.lang.String brokerUrl, java.lang.String topic, org.apache.spark.storage.StorageLevel storageLevel) { throw new RuntimeException(); }
  public  org.apache.spark.streaming.receiver.Receiver<java.lang.String> getReceiver () { throw new RuntimeException(); }
}
