name := """protobuf-default-value"""

version := "1.0"

scalaVersion := "2.11.6"

resolvers ++= Seq(
  "Twitter Maven Repo" at "http://maven.twttr.com/"
)

libraryDependencies ++= Seq(
  "com.twitter.elephantbird" % "elephant-bird-core" % "4.8",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)
