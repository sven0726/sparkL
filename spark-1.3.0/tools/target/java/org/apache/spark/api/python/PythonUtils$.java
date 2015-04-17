package org.apache.spark.api.python;
// no position
public  class PythonUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PythonUtils$ MODULE$ = null;
  public   PythonUtils$ () { throw new RuntimeException(); }
  /** Get the PYTHONPATH for PySpark, either from SPARK_HOME, if it is set, or from our JAR */
  public  java.lang.String sparkPythonPath () { throw new RuntimeException(); }
  /** Merge PYTHONPATHS with the appropriate separator. Ignores blank strings. */
  public  java.lang.String mergePythonPaths (scala.collection.Seq<java.lang.String> paths) { throw new RuntimeException(); }
  public  org.apache.spark.api.java.JavaRDD<java.lang.String> generateRDDWithNull (org.apache.spark.api.java.JavaSparkContext sc) { throw new RuntimeException(); }
  /**
   * Convert list of T into seq of T (for calling API with varargs)
   */
  public <T extends java.lang.Object> scala.collection.Seq<T> toSeq (java.util.List<T> cols) { throw new RuntimeException(); }
}
