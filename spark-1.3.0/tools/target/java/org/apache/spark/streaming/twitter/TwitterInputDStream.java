package org.apache.spark.streaming.twitter;
public  class TwitterInputDStream extends org.apache.spark.streaming.dstream.ReceiverInputDStream<twitter4j.Status> {
  public   TwitterInputDStream (org.apache.spark.streaming.StreamingContext ssc_, scala.Option<twitter4j.auth.Authorization> twitterAuth, scala.collection.Seq<java.lang.String> filters, org.apache.spark.storage.StorageLevel storageLevel) { throw new RuntimeException(); }
  private  twitter4j.auth.Authorization createOAuthAuthorization () { throw new RuntimeException(); }
  private  twitter4j.auth.Authorization authorization () { throw new RuntimeException(); }
  public  org.apache.spark.streaming.receiver.Receiver<twitter4j.Status> getReceiver () { throw new RuntimeException(); }
}
