name := """play-playground"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.14"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test

libraryDependencies += "uk.gov.hmrc" %% "play-frontend-hmrc-play-30" % "10.1.0"

libraryDependencies += "uk.gov.hmrc" %% "http-verbs-play-30" % "15.1.0"
libraryDependencies += "uk.gov.hmrc" %% "bootstrap-frontend-play-30" % "9.5.0"
libraryDependencies += "uk.gov.hmrc" %% "play-auditing-play-30" % "9.1.0"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"

resolvers += MavenRepository("HMRC-open-artefacts-maven2", "https://open.artefacts.tax.service.gov.uk/maven2")
resolvers += "HMRC-open-artefacts-ivy2" at "https://open.artefacts.tax.service.gov.uk/ivy2"

libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.2.0"

ThisBuild / libraryDependencySchemes += "org.scala-lang.modules" %% "scala-xml" % "always"

ThisBuild / evictionErrorLevel := Level.Warn
