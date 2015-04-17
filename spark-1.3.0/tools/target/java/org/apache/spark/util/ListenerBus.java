package org.apache.spark.util;
/**
 * An event bus which posts events to its listeners.
 */
public  interface ListenerBus<L extends java.lang.Object, E extends java.lang.Object> extends org.apache.spark.Logging {
  public  java.util.concurrent.CopyOnWriteArrayList<L> listeners () ;
  /**
   * Add a listener to listen events. This method is thread-safe and can be called in any thread.
   */
  public  void addListener (L listener) ;
  /**
   * Post the event to all registered listeners. The <code>postToAll</code> caller should guarantee calling
   * <code>postToAll</code> in the same thread for all events.
   */
  public  void postToAll (E event) ;
  /**
   * Post an event to the specified listener. <code>onPostEvent</code> is guaranteed to be called in the same
   * thread.
   */
  public  void onPostEvent (L listener, E event) ;
}
