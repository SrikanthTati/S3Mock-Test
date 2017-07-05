package com.test.s3Mock.utils

import com.typesafe.config.{Config, ConfigFactory}
import java.io.File


case class configFileNotFoundException() extends Exception


class ConfigFileReader(configFile: String) {

  val rootConfig = getRootConfig()

  private def getRootConfig(): Config = {
    //Load file based on TypeSafe's default system parameters
    if(System.getProperty("config.url") != null) {
      println(s"Loading config from config url.")
      return ConfigFactory.load()
    } else if(configFile != null) {
      val fileUrlPattern = "file:/(.+)".r
      val fileUrlPattern(path) = configFile
      println(s"Loading config from config file $path")
      return ConfigFactory.parseFile(new File(path)).withFallback(ConfigFactory.defaultReference())
    }

    println("No system property found for config file")
    throw new configFileNotFoundException()
  }
}