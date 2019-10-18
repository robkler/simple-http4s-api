name := """simple-http4s-api"""

version := "1.1"

scalaVersion := "2.12.8"

val http4sVersion = "0.20.0"
val circeVersion = "0.12.2"

resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"
resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-argonaut" % http4sVersion,
  "com.typesafe.play" %% "play-json" % "2.7.4",
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-jawn" % circeVersion,
  "com.chuusai" %% "shapeless" % "2.3.3",
  "org.scalatest" %% "scalatest" % "3.0.8"
)

//ScoverageSbtPlugin.ScoverageKeys.coverageExcludedPackages := ".*Api.*;.*WsService.*"
