package org.apache.spark.streaming.zeromq;
/**
 * A receiver to subscribe to ZeroMQ stream.
 */
public  class ZeroMQReceiver<T extends java.lang.Object> implements akka.actor.Actor, org.apache.spark.streaming.receiver.ActorHelper, org.apache.spark.Logging {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree().setOriginal(Select(Select(Ident(_root_), scala), scala.Nothing)), TypeTree().setOriginal(Select(Select(Ident(_root_), scala), scala.Any))))
  public   ZeroMQReceiver (java.lang.String publisherUrl, akka.zeromq.Subscribe subscribe, scala.Function1<scala.collection.Seq<akka.util.ByteString>, scala.collection.Iterator<T>> bytesToObjects, scala.reflect.ClassTag<T> evidence$1) { throw new RuntimeException(); }
  public  void preStart () { throw new RuntimeException(); }
  public  scala.PartialFunction<java.lang.Object, scala.runtime.BoxedUnit> receive () { throw new RuntimeException(); }
}
