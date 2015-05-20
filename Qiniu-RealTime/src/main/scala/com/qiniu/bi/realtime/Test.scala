package com.qiniu.bi.realtime


import com.mongodb.casbah.{MongoClientURI, MongoClient}
import com.mongodb.casbah.commons.MongoDBObject

/**
 * Created by qiniu on 15/5/14.
 */
object Test {
  def main(args: Array[String]) {
    val builder = MongoDBObject("_id"->"12")
    builder.put("$push",MongoDBObject("tt"->1))
      builder.put("$set",MongoDBObject("rr"->1))
     // builder.put("$push",MongoDBObject("tt"->1)
    //builder += ("$push"->{"rr"->2})
    //val update = MongoDBObject("_id"->key) ++ ("$push"->{"tt"->timeFormat.format(datetime)})
    //coll.update(query,builder.result,upsert=true)

   /* val builder = MongoDBObject.newBuilder
    builder += ("_id"->1)
    builder += ("$push"->{"tt"->2})
    builder += ("$push2"->{"tt"->22})
*/
    println(builder)
    val mongoClientURI = MongoClientURI("mongodb://115.231.182.84:27017/")
    val mongoClient = MongoClient(mongoClientURI)
    //val mongoClient = MongoClient("115.231.182.84")
    val db = mongoClient("io_rate")
    //val datetime = new Date()
    //println(db.getStats())

    println("14321044607823048")
    println("14321044607823048".substring(0,10))
  }
}
