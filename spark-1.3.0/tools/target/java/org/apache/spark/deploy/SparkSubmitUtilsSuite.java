package org.apache.spark.deploy;
public  class SparkSubmitUtilsSuite extends org.scalatest.FunSuite implements org.scalatest.BeforeAndAfterAll {
  public   SparkSubmitUtilsSuite () { throw new RuntimeException(); }
  private  java.io.OutputStream noOpOutputStream () { throw new RuntimeException(); }
  /** Simple PrintStream that reads data into a buffer */
  private  class BufferPrintStream extends java.io.PrintStream {
    public   BufferPrintStream () { throw new RuntimeException(); }
    public  scala.collection.mutable.ArrayBuffer<java.lang.String> lineBuffer () { throw new RuntimeException(); }
    public  void println (java.lang.String line) { throw new RuntimeException(); }
  }
  public  void beforeAll () { throw new RuntimeException(); }
}
