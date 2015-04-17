package org.apache.spark.scheduler;
// no position
public  class EventLoggingListener$ implements org.apache.spark.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final EventLoggingListener$ MODULE$ = null;
  public   EventLoggingListener$ () { throw new RuntimeException(); }
  public  java.lang.String IN_PROGRESS () { throw new RuntimeException(); }
  public  java.lang.String DEFAULT_LOG_DIR () { throw new RuntimeException(); }
  public  java.lang.String SPARK_VERSION_KEY () { throw new RuntimeException(); }
  public  java.lang.String COMPRESSION_CODEC_KEY () { throw new RuntimeException(); }
  private  org.apache.hadoop.fs.permission.FsPermission LOG_FILE_PERMISSIONS () { throw new RuntimeException(); }
  private  scala.collection.mutable.HashMap<java.lang.String, org.apache.spark.io.CompressionCodec> codecMap () { throw new RuntimeException(); }
  /**
   * Write metadata about an event log to the given stream.
   * The metadata is encoded in the first line of the event log as JSON.
   * <p>
   * @param logStream Raw output stream to the event log file.
   */
  public  void initEventLog (java.io.OutputStream logStream) { throw new RuntimeException(); }
  /**
   * Return a file-system-safe path to the log file for the given application.
   * <p>
   * Note that because we currently only create a single log file for each application,
   * we must encode all the information needed to parse this event log in the file name
   * instead of within the file itself. Otherwise, if the file is compressed, for instance,
   * we won't know which codec to use to decompress the metadata needed to open the file in
   * the first place.
   * <p>
   * @param logBaseDir Directory where the log file will be written.
   * @param appId A unique app ID.
   * @param compressionCodecName Name to identify the codec used to compress the contents
   *                             of the log, or None if compression is not enabled.
   * @return A path which consists of file-system-safe characters.
   */
  public  java.lang.String getLogPath (java.lang.String logBaseDir, java.lang.String appId, scala.Option<java.lang.String> compressionCodecName) { throw new RuntimeException(); }
  /**
   * Opens an event log file and returns an input stream that contains the event data.
   * <p>
   * @return input stream that holds one JSON record per line.
   */
  public  java.io.InputStream openEventLog (org.apache.hadoop.fs.Path log, org.apache.hadoop.fs.FileSystem fs) { throw new RuntimeException(); }
}
