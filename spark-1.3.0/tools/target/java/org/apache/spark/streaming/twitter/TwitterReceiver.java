package org.apache.spark.streaming.twitter;
public  class TwitterReceiver extends org.apache.spark.streaming.receiver.Receiver<twitter4j.Status> implements org.apache.spark.Logging {
  public   TwitterReceiver (twitter4j.auth.Authorization twitterAuth, scala.collection.Seq<java.lang.String> filters, org.apache.spark.storage.StorageLevel storageLevel) { throw new RuntimeException(); }
  private  twitter4j.TwitterStream twitterStream () { throw new RuntimeException(); }
  private  boolean stopped () { throw new RuntimeException(); }
  public  void onStart () { throw new RuntimeException(); }
  public  void onStop () { throw new RuntimeException(); }
  private  void setTwitterStream (twitter4j.TwitterStream newTwitterStream) { throw new RuntimeException(); }
}
