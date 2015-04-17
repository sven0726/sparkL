package org.apache.spark.deploy;
public  class SparkSubmitSuite extends org.scalatest.FunSuite implements org.scalatest.Matchers, org.apache.spark.util.ResetSystemProperties, org.scalatest.concurrent.Timeouts {
  public   SparkSubmitSuite () { throw new RuntimeException(); }
  public  void beforeAll () { throw new RuntimeException(); }
  private  java.io.OutputStream noOpOutputStream () { throw new RuntimeException(); }
  /** Simple PrintStream that reads data into a buffer */
  private  class BufferPrintStream extends java.io.PrintStream {
    public   BufferPrintStream () { throw new RuntimeException(); }
    public  scala.collection.mutable.ArrayBuffer<java.lang.String> lineBuffer () { throw new RuntimeException(); }
    public  void println (java.lang.String line) { throw new RuntimeException(); }
  }
  /** Returns true if the script exits and the given search string is printed. */
  private  void testPrematureExit (java.lang.String[] input, java.lang.String searchString) { throw new RuntimeException(); }
  /**
   * Test whether the launch environment is correctly set up in standalone cluster mode.
   * @param useRest whether to use the REST submission gateway introduced in Spark 1.3
   */
  private  void testStandaloneCluster (boolean useRest) { throw new RuntimeException(); }
  private  void runSparkSubmit (scala.collection.Seq<java.lang.String> args) { throw new RuntimeException(); }
  private  void forConfDir (scala.collection.immutable.Map<java.lang.String, java.lang.String> defaults, scala.Function1<java.lang.String, scala.runtime.BoxedUnit> f) { throw new RuntimeException(); }
}
