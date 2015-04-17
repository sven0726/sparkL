package org.apache.spark.serializer;
public  class SerializableClass2 implements scala.Serializable {
  public  java.lang.Object objectField () { throw new RuntimeException(); }
  // not preceding
  public   SerializableClass2 (java.lang.Object objectField) { throw new RuntimeException(); }
}
