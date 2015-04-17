package org.apache.spark.streaming.kafka;
/**
 * This is an abstract base class for Kafka testsuites. This has the functionality to set up
 * and tear down local Kafka servers, and to push data using Kafka producers.
 */
public abstract class KafkaStreamSuiteBase extends org.scalatest.FunSuite implements org.scalatest.concurrent.Eventually, org.apache.spark.Logging {
  public   KafkaStreamSuiteBase () { throw new RuntimeException(); }
  private  java.lang.String zkHost () { throw new RuntimeException(); }
  private  int zkPort () { throw new RuntimeException(); }
  private  int zkConnectionTimeout () { throw new RuntimeException(); }
  private  int zkSessionTimeout () { throw new RuntimeException(); }
  private  org.apache.spark.streaming.kafka.KafkaStreamSuiteBase.EmbeddedZookeeper zookeeper () { throw new RuntimeException(); }
  private  java.lang.String brokerHost () { throw new RuntimeException(); }
  private  int brokerPort () { throw new RuntimeException(); }
  private  kafka.server.KafkaConfig brokerConf () { throw new RuntimeException(); }
  private  kafka.server.KafkaServer server () { throw new RuntimeException(); }
  private  kafka.producer.Producer<java.lang.String, java.lang.String> producer () { throw new RuntimeException(); }
  private  boolean zkReady () { throw new RuntimeException(); }
  private  boolean brokerReady () { throw new RuntimeException(); }
  protected  org.I0Itec.zkclient.ZkClient zkClient () { throw new RuntimeException(); }
  public  java.lang.String zkAddress () { throw new RuntimeException(); }
  public  java.lang.String brokerAddress () { throw new RuntimeException(); }
  public  void setupKafka () { throw new RuntimeException(); }
  public  void tearDownKafka () { throw new RuntimeException(); }
  public  void createTopic (java.lang.String topic) { throw new RuntimeException(); }
  public  void sendMessages (java.lang.String topic, scala.collection.immutable.Map<java.lang.String, java.lang.Object> messageToFreq) { throw new RuntimeException(); }
  public  void sendMessages (java.lang.String topic, java.lang.String[] messages) { throw new RuntimeException(); }
  private  java.util.Properties getBrokerConfig () { throw new RuntimeException(); }
  private  java.util.Properties getProducerConfig () { throw new RuntimeException(); }
  private  void waitUntilMetadataIsPropagated (java.lang.String topic, int partition) { throw new RuntimeException(); }
  public  class EmbeddedZookeeper {
    public  java.lang.String zkConnect () { throw new RuntimeException(); }
    // not preceding
    public   EmbeddedZookeeper (java.lang.String zkConnect) { throw new RuntimeException(); }
    public  scala.util.Random random () { throw new RuntimeException(); }
    public  java.io.File snapshotDir () { throw new RuntimeException(); }
    public  java.io.File logDir () { throw new RuntimeException(); }
    public  org.apache.zookeeper.server.ZooKeeperServer zookeeper () { throw new RuntimeException(); }
    public  java.lang.String ip () { throw new RuntimeException(); }
    public  int port () { throw new RuntimeException(); }
    public  org.apache.zookeeper.server.NIOServerCnxnFactory factory () { throw new RuntimeException(); }
    public  int actualPort () { throw new RuntimeException(); }
    public  void shutdown () { throw new RuntimeException(); }
  }
}
