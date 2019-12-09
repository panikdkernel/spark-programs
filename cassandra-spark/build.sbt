name := "usersByCountry"
version := "1.0"

scalaVersion := "2.11.8"

resolvers += "Spark Packages Repo" at "https://dl.bintray.com/spark-packages/maven"
//libraryDependencies += "datastax" % "spark-cassandra-connector" % "2.3.1-s_2.11"
// https://mvnrepository.com/artifact/org.apache.spark/spark-core_2.11
libraryDependencies += "org.apache.spark" %%"spark-core" % "2.1.1" % "provided"
// https://mvnrepository.com/artifact/com.datastax.spark/spark-cassandra-connector
libraryDependencies += "com.datastax.spark" %% "spark-cassandra-connector" % "2.3.1"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.1.1"
