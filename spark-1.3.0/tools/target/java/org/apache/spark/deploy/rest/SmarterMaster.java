package org.apache.spark.deploy.rest;
/**
 * A mock standalone Master that keeps track of drivers that have been submitted.
 * <p>
 * If a driver is submitted, its state is immediately set to RUNNING.
 * If an existing driver is killed, its state is immediately set to KILLED.
 * If an existing driver's status is requested, its state is returned in the response.
 * Submits are always successful while kills and status requests are successful only
 * if the driver was submitted in the past.
 */
public  class SmarterMaster implements akka.actor.Actor {
  public   SmarterMaster () { throw new RuntimeException(); }
  private  int counter () { throw new RuntimeException(); }
  private  scala.collection.mutable.HashMap<java.lang.String, scala.Enumeration.Value> submittedDrivers () { throw new RuntimeException(); }
  public  scala.PartialFunction<java.lang.Object, scala.runtime.BoxedUnit> receive () { throw new RuntimeException(); }
}
