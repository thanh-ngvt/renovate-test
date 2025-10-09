/**
 * Plugin to replace conf/swagger-conf.js to the swagger-initilizer from the swagger-ui-dist web jars
 */

import com.typesafe.sbt.web.{PathMapping, SbtWeb}
import com.typesafe.sbt.web.pipeline.Pipeline
import sbt.Keys.*
import sbt.*

trait SwaggerUiKeys {
  val swaggerUiGenerate: TaskKey[Pipeline.Stage] = taskKey("generate swagger-ui site")
}

object SwaggerUiPlugin extends AutoPlugin {
  override def requires: Plugins = SbtWeb
  override def trigger = allRequirements

  object autoImport extends SwaggerUiKeys

  import autoImport.*

  val swaggerUiVersion = "5.29.1"

  override lazy val projectSettings = Seq(
    swaggerUiGenerate := { mappings: Seq[PathMapping] =>
      val swaggerDefaultConf = (Compile / target).value / "web"/ "web-modules" / "main" / "webjars" / "lib" / "swagger-ui-dist" / "swagger-initializer.js"
      val content = IO.read((Compile / resourceDirectory).value / "swagger-conf.js")
      IO.write(swaggerDefaultConf, content)
      mappings
    },
    libraryDependencies ++= Seq(
      "org.webjars.npm" % "swagger-ui-dist" % swaggerUiVersion % Provided
    )
  )
}