package com.qiniu.bi.common

import java.nio.{CharBuffer, ByteBuffer}
import java.nio.charset.{CharsetDecoder, Charset}

import scala.collection.immutable.Map

/**
 * Created by qiniu on 15/5/10.
 */
object RealtimeUtil {

  /**
   * Helper function to convert a map of CharSequence to a map of String.
   */

  def toStringMap(charSeqMap: java.util.Map[CharSequence, CharSequence]): Map[String, String] = {
    val stringMap = new scala.collection.mutable.HashMap[String, String]
    import scala.collection.JavaConversions._
    charSeqMap.foreach(kv => {
      stringMap += (kv._1.toString -> kv._2.toString)
    })

    stringMap.toMap
  }

  /**
   * Change AvroFlumeEvent'body to String
   * @param buffer   Change AvroFlumeEvent'body to String
   * @return
   */
  def getBodyAsString(buffer: ByteBuffer): String = {
    val charset: Charset = Charset.forName("UTF-8")

    val decoder: CharsetDecoder = charset.newDecoder()
    val charBuffer: CharBuffer = decoder.decode(buffer.asReadOnlyBuffer());

    // charBuffer = decoder.decode(buffer);//用这个的话，只能输出来一次结果，第二次显示为空

    charBuffer.toString()
  }
}
