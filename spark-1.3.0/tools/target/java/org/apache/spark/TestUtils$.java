package org.apache.spark;
// no position
/**
 * Utilities for tests. Included in main codebase since it's used by multiple
 * projects.
 * <p>
 * TODO: See if we can move this to the test codebase by specifying
 * test dependencies between projects.
 */
public  class TestUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final TestUtils$ MODULE$ = null;
  public   TestUtils$ () { throw new RuntimeException(); }
  /**
   * Create a jar that defines classes with the given names.
   * <p>
   * Note: if this is used during class loader tests, class names should be unique
   * in order to avoid interference between tests.
   */
  public  java.net.URL createJarWithClasses (scala.collection.Seq<java.lang.String> classNames, java.lang.String toStringValue, scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> classNamesWithBase, scala.collection.Seq<java.net.URL> classpathUrls) { throw new RuntimeException(); }
  /**
   * Create a jar file containing multiple files. The <code>files</code> map contains a mapping of
   * file names in the jar file to their contents.
   */
  public  java.net.URL createJarWithFiles (scala.collection.immutable.Map<java.lang.String, java.lang.String> files, java.io.File dir) { throw new RuntimeException(); }
  /**
   * Create a jar file that contains this set of files. All files will be located at the root
   * of the jar.
   */
  public  java.net.URL createJar (scala.collection.Seq<java.io.File> files, java.io.File jarFile) { throw new RuntimeException(); }
  /**
   * Create a jar file that contains this set of files. All files will be located at the root
   * of the jar.
   */
  private  javax.tools.JavaFileObject.Kind SOURCE () { throw new RuntimeException(); }
  private  java.net.URI createURI (java.lang.String name) { throw new RuntimeException(); }
  /** Creates a compiled class with the given name. Class file will be placed in destDir. */
  public  java.io.File createCompiledClass (java.lang.String className, java.io.File destDir, java.lang.String toStringValue, java.lang.String baseClass, scala.collection.Seq<java.net.URL> classpathUrls) { throw new RuntimeException(); }
}
