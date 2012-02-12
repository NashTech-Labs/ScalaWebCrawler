name := "ScalaWebCrawler"

scalaVersion := "2.9.1"

version := "1.0"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Central Repo" at "http://repo1.maven.org/maven2"

libraryDependencies += "edu.uci.ics" % "crawler4j" % "3.1"

libraryDependencies += "org.scalatra" %% "scalatra-scalatest" % "2.0.1"
