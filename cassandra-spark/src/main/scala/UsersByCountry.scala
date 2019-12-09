package com.accn

//import org.apache.log4j.{Level, Logger}

import org.apache.spark.{SparkContext, SparkConf}
import com.datastax.spark.connector._
import org.apache.spark.sql.cassandra._


object UsersByCountry{

  def main(args: Array[String]) {
 //   Logger.getLogger("org").setLevel(Level.OFF)
  //  Logger.getLogger("akka").setLevel(Level.OFF)
    println("program started")
    
	val conf = new SparkConf().setAppName("users-per-country")
   	 val sc = new SparkContext(conf)
   
	val webclicksRDD=sc.cassandraTable("goshopping","iplookup")

	val webclicksCols=webclicksRDD.map(row=>(row.getString("ip"),row.getString("country"),row.getString("state"),row.getString("city"),row.getString("lat"),row.getString("lng")))
	
        val userTimeRDD=webclicksCols.map(element=>(element._2,1))

        val userTotalTime=userTimeRDD.reduceByKey((x,y)=>x+y)
	
	println("users by country") 
	//val userMinTime=userTotalTime.sortBy(_._2)
	userTotalTime.collect.foreach(println)
	//userMinTime.take(1).foreach(println)
	
	//println("Maximum time in the GoShopping website") 
	//val userMaxTime=userTotalTime.sortBy(_._2,false)
	//userMaxTime.collect.foreach(println)
	//userMaxTime.take(1).foreach(println)


  }
} 
