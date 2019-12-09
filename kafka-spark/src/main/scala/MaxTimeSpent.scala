package com.accenture

import org.apache.spark.{SparkContext, SparkConf}

object MaxTimeSpent {

	def main(args: Array[String]) {

		val conf = new SparkConf().setAppName("Total Time Spent Application")
		val sc = new SparkContext(conf)
		val inputFileName = "file:///home/vagrant/goShopping_WebClicks.dat"
		val srcFile = sc.textFile(inputFileName)
		val validRecords = srcFile.filter(line => !line.contains("date"))
		val recordCols = validRecords.map(line => line.split("\t"))
		val maxTime = recordCols.map(field => (field(4),field(6).toInt)).reduceByKey(_+_).collect.maxBy(_._2)
		println(maxTime)

	}
}
