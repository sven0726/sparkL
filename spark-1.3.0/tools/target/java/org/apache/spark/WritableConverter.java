package org.apache.spark;
/**  &#x7248;&#x672c;1.3.0&#x540e;  &#x4ee3;&#x66ff;&#x4e0a;&#x9762;sparkcontext  object&#x4e2d;&#x7684;&#x9690;&#x5f0f;&#x8f6c;&#x6362;
 * A class encapsulating how to convert some type T to Writable. It stores both the Writable class
 * corresponding to T (e.g. IntWritable for Int) and a function for doing the conversion.
 * The getter for the writable class takes a ClassTag[T] in case this is a generic object
 * that doesn't know the type of T when it is created. This sounds strange but is necessary to
 * support converting subclasses of Writable to themselves (writableWritableConverter).
 */
public  class WritableConverter<T extends java.lang.Object> implements java.io.Serializable {
  static public <T extends java.lang.Object, W extends org.apache.hadoop.io.Writable> org.apache.spark.WritableConverter<T> simpleWritableConverter (scala.Function1<W, T> convert, scala.reflect.ClassTag<W> evidence$30) { throw new RuntimeException(); }
  static public  org.apache.spark.WritableConverter<java.lang.Object> intWritableConverter () { throw new RuntimeException(); }
  static public  org.apache.spark.WritableConverter<java.lang.Object> longWritableConverter () { throw new RuntimeException(); }
  static public  org.apache.spark.WritableConverter<java.lang.Object> doubleWritableConverter () { throw new RuntimeException(); }
  static public  org.apache.spark.WritableConverter<java.lang.Object> floatWritableConverter () { throw new RuntimeException(); }
  static public  org.apache.spark.WritableConverter<java.lang.Object> booleanWritableConverter () { throw new RuntimeException(); }
  static public  org.apache.spark.WritableConverter<byte[]> bytesWritableConverter () { throw new RuntimeException(); }
  static public  org.apache.spark.WritableConverter<java.lang.String> stringWritableConverter () { throw new RuntimeException(); }
  static public <T extends org.apache.hadoop.io.Writable> org.apache.spark.WritableConverter<T> writableWritableConverter () { throw new RuntimeException(); }
  public  scala.Function1<scala.reflect.ClassTag<T>, java.lang.Class<? extends org.apache.hadoop.io.Writable>> writableClass () { throw new RuntimeException(); }
  public  scala.Function1<org.apache.hadoop.io.Writable, T> convert () { throw new RuntimeException(); }
  // not preceding
  public   WritableConverter (scala.Function1<scala.reflect.ClassTag<T>, java.lang.Class<? extends org.apache.hadoop.io.Writable>> writableClass, scala.Function1<org.apache.hadoop.io.Writable, T> convert) { throw new RuntimeException(); }
}
