package org.apache.spark.serializer;
public  class ExternalizableClass implements java.io.Externalizable {
  public   ExternalizableClass () { throw new RuntimeException(); }
  public  void writeExternal (java.io.ObjectOutput out) { throw new RuntimeException(); }
  public  void readExternal (java.io.ObjectInput in) { throw new RuntimeException(); }
}
