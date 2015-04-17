package org.apache.spark.deploy.rest;
/**
 * A mock standalone Master that responds with dummy messages.
 * In all responses, the success parameter is always true.
 */
public  class DummyMaster implements akka.actor.Actor {
  public   DummyMaster (java.lang.String submitId, java.lang.String submitMessage, java.lang.String killMessage, scala.Enumeration.Value state, scala.Option<java.lang.Exception> exception) { throw new RuntimeException(); }
  public  scala.PartialFunction<java.lang.Object, scala.runtime.BoxedUnit> receive () { throw new RuntimeException(); }
}
