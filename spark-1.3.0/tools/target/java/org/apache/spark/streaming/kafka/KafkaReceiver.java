package org.apache.spark.streaming.kafka;
public  class KafkaReceiver<K extends java.lang.Object, V extends java.lang.Object, U extends kafka.serializer.Decoder<?>, T extends kafka.serializer.Decoder<?>> extends org.apache.spark.streaming.receiver.Receiver<scala.Tuple2<K, V>> implements org.apache.spark.Logging {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree().setOriginal(Select(Select(Ident(_root_), scala), scala.Nothing)), TypeTree().setOriginal(Select(Select(Ident(_root_), scala), scala.Any))))
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree().setOriginal(Select(Select(Ident(_root_), scala), scala.Nothing)), TypeTree().setOriginal(Select(Select(Ident(_root_), scala), scala.Any))))
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree().setOriginal(Select(Select(Ident(_root_), scala), scala.Nothing)), TypeTree().setOriginal(ExistentialTypeTree(AppliedTypeTree(Select(Select(Ident(kafka), kafka.serializer), kafka.serializer.Decoder), List(TypeTree().setOriginal(Ident(newTypeName("_$3"))))), List(TypeDef(Modifiers(DEFERRED | SYNTHETIC), newTypeName("_$3"), List(), TypeBoundsTree(Select(Select(Ident(_root_), scala), scala.Nothing), Select(Select(Ident(_root_), scala), scala.Any))))))))
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree().setOriginal(Select(Select(Ident(_root_), scala), scala.Nothing)), TypeTree().setOriginal(ExistentialTypeTree(AppliedTypeTree(Select(Select(Ident(kafka), kafka.serializer), kafka.serializer.Decoder), List(TypeTree().setOriginal(Ident(newTypeName("_$4"))))), List(TypeDef(Modifiers(DEFERRED | SYNTHETIC), newTypeName("_$4"), List(), TypeBoundsTree(Select(Select(Ident(_root_), scala), scala.Nothing), Select(Select(Ident(_root_), scala), scala.Any))))))))
  public   KafkaReceiver (scala.collection.Map<java.lang.String, java.lang.String> kafkaParams, scala.collection.Map<java.lang.String, java.lang.Object> topics, org.apache.spark.storage.StorageLevel storageLevel, scala.reflect.ClassTag<K> evidence$5, scala.reflect.ClassTag<V> evidence$6, scala.reflect.ClassTag<U> evidence$7, scala.reflect.ClassTag<T> evidence$8) { throw new RuntimeException(); }
  public  kafka.consumer.ConsumerConnector consumerConnector () { throw new RuntimeException(); }
  public  void onStop () { throw new RuntimeException(); }
  public  void onStart () { throw new RuntimeException(); }
  private  class MessageHandler implements java.lang.Runnable {
    public   MessageHandler (kafka.consumer.KafkaStream<K, V> stream) { throw new RuntimeException(); }
    public  void run () { throw new RuntimeException(); }
  }
}
