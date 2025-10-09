name := """play-java-forms-hcaptcha"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)
  //.enablePlugins(PlayNettyServer).disablePlugins(PlayPekkoHttpServer) // uncomment to use the Netty backend

crossScalaVersions := Seq("2.13.16", "3.3.5")

scalaVersion := crossScalaVersions.value.head

(Test / testOptions) := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))

libraryDependencies ++= Seq(guice, javaWs,
"org.webjars.npm" % "jquery" % "3.7.1",
      "org.webjars.npm" % "jquery-ui" % "1.14.1",
      "org.webjars.npm" % "github-com-fancyapps-fancybox" % "3.5.7",
      "com.microsoft.sqlserver" % "mssql-jdbc" % "13.2.0.jre11",
      "com.github.dwickern" %% "swagger-play3.0" % "4.0.0",
      "org.mindrot" % "jbcrypt" % "0.4",
      "org.apache.commons" % "commons-text" % "1.14.0",
      "org.apache.commons" % "commons-email" % "1.6.0",
      "org.apache.velocity" % "velocity-engine-core" % "2.4.1",
      "commons-codec" % "commons-codec" % "1.19.0",
      "org.apache.tika" % "tika-core" % "3.2.3",
      "net.coobird" % "thumbnailator" % "0.4.20",
      "com.opencsv" % "opencsv" % "5.11.0",
      "com.github.mwiede" % "jsch" % "2.27.3",
      "com.nimbusds" % "oauth2-oidc-sdk" % "11.29.1",
      "net.logstash.logback" % "logstash-logback-encoder" % "8.1" exclude("com.fasterxml.jackson.core", "jackson-databind"), // jackson gets excluded because of version conflict
      "org.webjars.npm" % "github-com-kenwheeler-slick" % "1.8.0",
      "org.webjars.npm" % "bootstrap" % "3.4.1",
      "org.webjars.npm" % "bootstrap-datepicker" % "1.10.0",
      "org.mockito" % "mockito-core" % "5.20.0" % Test,
      "jakarta.xml.ws" % "jakarta.xml.ws-api" % "4.0.2",
      "com.sun.xml.messaging.saaj" % "saaj-impl" % "3.0.4"
    )

scalacOptions ++= List("-Werror")
javacOptions ++= Seq(
  "-Xlint:unchecked",
  "-Xlint:deprecation",
  "-Werror"
) 
