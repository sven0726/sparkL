package org.apache.spark.streaming.twitter;
// no position
public  class TwitterUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final TwitterUtils$ MODULE$ = null;
  public   TwitterUtils$ () { throw new RuntimeException(); }
  /**
   * Create a input stream that returns tweets received from Twitter.
   * @param ssc         StreamingContext object
   * @param twitterAuth Twitter4J authentication, or None to use Twitter4J's default OAuth
   *        authorization; this uses the system properties twitter4j.oauth.consumerKey,
   *        twitter4j.oauth.consumerSecret, twitter4j.oauth.accessToken and
   *        twitter4j.oauth.accessTokenSecret
   * @param filters Set of filter strings to get only those tweets that match them
   * @param storageLevel Storage level to use for storing the received objects
   */
  public  org.apache.spark.streaming.dstream.ReceiverInputDStream<twitter4j.Status> createStream (org.apache.spark.streaming.StreamingContext ssc, scala.Option<twitter4j.auth.Authorization> twitterAuth, scala.collection.Seq<java.lang.String> filters, org.apache.spark.storage.StorageLevel storageLevel) { throw new RuntimeException(); }
  /**
   * Create a input stream that returns tweets received from Twitter using Twitter4J's default
   * OAuth authentication; this requires the system properties twitter4j.oauth.consumerKey,
   * twitter4j.oauth.consumerSecret, twitter4j.oauth.accessToken and
   * twitter4j.oauth.accessTokenSecret.
   * Storage level of the data will be the default StorageLevel.MEMORY_AND_DISK_SER_2.
   * @param jssc   JavaStreamingContext object
   */
  public  org.apache.spark.streaming.api.java.JavaReceiverInputDStream<twitter4j.Status> createStream (org.apache.spark.streaming.api.java.JavaStreamingContext jssc) { throw new RuntimeException(); }
  /**
   * Create a input stream that returns tweets received from Twitter using Twitter4J's default
   * OAuth authentication; this requires the system properties twitter4j.oauth.consumerKey,
   * twitter4j.oauth.consumerSecret, twitter4j.oauth.accessToken and
   * twitter4j.oauth.accessTokenSecret.
   * Storage level of the data will be the default StorageLevel.MEMORY_AND_DISK_SER_2.
   * @param jssc    JavaStreamingContext object
   * @param filters Set of filter strings to get only those tweets that match them
   */
  public  org.apache.spark.streaming.api.java.JavaReceiverInputDStream<twitter4j.Status> createStream (org.apache.spark.streaming.api.java.JavaStreamingContext jssc, java.lang.String[] filters) { throw new RuntimeException(); }
  /**
   * Create a input stream that returns tweets received from Twitter using Twitter4J's default
   * OAuth authentication; this requires the system properties twitter4j.oauth.consumerKey,
   * twitter4j.oauth.consumerSecret, twitter4j.oauth.accessToken and
   * twitter4j.oauth.accessTokenSecret.
   * @param jssc         JavaStreamingContext object
   * @param filters      Set of filter strings to get only those tweets that match them
   * @param storageLevel Storage level to use for storing the received objects
   */
  public  org.apache.spark.streaming.api.java.JavaReceiverInputDStream<twitter4j.Status> createStream (org.apache.spark.streaming.api.java.JavaStreamingContext jssc, java.lang.String[] filters, org.apache.spark.storage.StorageLevel storageLevel) { throw new RuntimeException(); }
  /**
   * Create a input stream that returns tweets received from Twitter.
   * Storage level of the data will be the default StorageLevel.MEMORY_AND_DISK_SER_2.
   * @param jssc        JavaStreamingContext object
   * @param twitterAuth Twitter4J Authorization
   */
  public  org.apache.spark.streaming.api.java.JavaReceiverInputDStream<twitter4j.Status> createStream (org.apache.spark.streaming.api.java.JavaStreamingContext jssc, twitter4j.auth.Authorization twitterAuth) { throw new RuntimeException(); }
  /**
   * Create a input stream that returns tweets received from Twitter.
   * Storage level of the data will be the default StorageLevel.MEMORY_AND_DISK_SER_2.
   * @param jssc        JavaStreamingContext object
   * @param twitterAuth Twitter4J Authorization
   * @param filters     Set of filter strings to get only those tweets that match them
   */
  public  org.apache.spark.streaming.api.java.JavaReceiverInputDStream<twitter4j.Status> createStream (org.apache.spark.streaming.api.java.JavaStreamingContext jssc, twitter4j.auth.Authorization twitterAuth, java.lang.String[] filters) { throw new RuntimeException(); }
  /**
   * Create a input stream that returns tweets received from Twitter.
   * @param jssc         JavaStreamingContext object
   * @param twitterAuth  Twitter4J Authorization object
   * @param filters      Set of filter strings to get only those tweets that match them
   * @param storageLevel Storage level to use for storing the received objects
   */
  public  org.apache.spark.streaming.api.java.JavaReceiverInputDStream<twitter4j.Status> createStream (org.apache.spark.streaming.api.java.JavaStreamingContext jssc, twitter4j.auth.Authorization twitterAuth, java.lang.String[] filters, org.apache.spark.storage.StorageLevel storageLevel) { throw new RuntimeException(); }
}
