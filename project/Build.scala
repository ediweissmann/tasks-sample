import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "tasksapp"
    val appVersion      = "1.0-SNAPSHOT"

  val jerkson = "com.codahale" % "jerkson_2.9.1" % "0.5.0"
  val squeryl = "org.squeryl" %% "squeryl" % "0.9.5-6"
  val h2 = "com.h2database" % "h2" % "1.2.127"

  val appDependencies = Seq(
    jerkson, h2, squeryl
  )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add your own project settings here      
    )

  // jerkson from codahale
  resolvers += "CodaHale repository" at "http://repo.codahale.com"
}
