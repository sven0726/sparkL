package org.apache.spark.streaming.mqtt;
public  class MQTTStreamSuite extends org.scalatest.FunSuite implements org.scalatest.concurrent.Eventually, org.scalatest.BeforeAndAfter {
  public   MQTTStreamSuite () { throw new RuntimeException(); }
  private  org.apache.spark.streaming.Duration batchDuration () { throw new RuntimeException(); }
  private  java.lang.String master () { throw new RuntimeException(); }
  private  java.lang.String framework () { throw new RuntimeException(); }
  private  int freePort () { throw new RuntimeException(); }
  private  java.lang.String brokerUri () { throw new RuntimeException(); }
  private  java.lang.String topic () { throw new RuntimeException(); }
  private  java.io.File persistenceDir () { throw new RuntimeException(); }
  private  org.apache.spark.streaming.StreamingContext ssc () { throw new RuntimeException(); }
  private  org.apache.activemq.broker.BrokerService broker () { throw new RuntimeException(); }
  private  org.apache.activemq.broker.TransportConnector connector () { throw new RuntimeException(); }
  private  void setupMQTT () { throw new RuntimeException(); }
  private  void tearDownMQTT () { throw new RuntimeException(); }
  private  int findFreePort () { throw new RuntimeException(); }
  public  void publishData (java.lang.String data) { throw new RuntimeException(); }
  /**
   * Block until at least one receiver has started or timeout occurs.
   */
  private  void waitForReceiverToStart () { throw new RuntimeException(); }
}
