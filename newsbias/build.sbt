name := """newsbias"""

version := "1.0-SNAPSHOT"

scalacOptions ++= Seq("-deprecation", "-unchecked")

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")


libraryDependencies ++= Seq(
  // Select Play modules
  //jdbc,      // The JDBC connection pool and the play.api.db API
  //anorm,     // Scala RDBMS Library
  //javaJdbc,  // Java database API
  //javaEbean, // Java Ebean plugin
  //javaJpa,   // Java JPA plugin
  //filters,   // A set of built-in filters
  javaCore, // The core Java API
  // WebJars pull in client-side web libraries
  "org.webjars" %% "webjars-play" % "2.2.0",
  "org.webjars" % "bootstrap" % "2.3.1",
  // Add your own project dependencies in the form:
  // "group" % "artifact" % "version" 
  "org.apache.hadoop" % "hadoop-common" % "2.0.0-cdh4.6.0",
  "org.apache.hadoop" % "hadoop-client" % "2.0.0-mr1-cdh4.6.0",
  "org.apache.hbase" % "hbase" % "0.94.15-cdh4.6.0"
)

play.Project.playScalaSettings

resolvers += "cloudera" at "https://repository.cloudera.com/artifactory/cloudera-repos"