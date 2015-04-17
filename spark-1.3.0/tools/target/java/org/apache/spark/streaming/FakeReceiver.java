package org.apache.spark.streaming;
/**
 * An implementation of Receiver that is used for testing a receiver's life cycle.
 */
public  class FakeReceiver extends org.apache.spark.streaming.receiver.Receiver<java.lang.Object> {
  public   FakeReceiver (boolean sendData) { throw new RuntimeException(); }
  public  java.lang.Thread otherThread () { throw new RuntimeException(); }
  public  boolean receiving () { throw new RuntimeException(); }
  public  boolean onStartCalled () { throw new RuntimeException(); }
  public  boolean onStopCalled () { throw new RuntimeException(); }
  public  void onStart () { throw new RuntimeException(); }
  public  void onStop () { throw new RuntimeException(); }
  public  void reset () { throw new RuntimeException(); }
}
