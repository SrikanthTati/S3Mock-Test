package com.test.s3Mock.utils

import org.scalatest.FlatSpec
import com.typesafe.config.ConfigException

class ConfigFileReaderTest extends FlatSpec {

  val configFile = getClass.getResource("/test.conf").toString
  println("Reading config from " + configFile)

  val ep = s3Mock.endpoint //Uncomment this link to make test fail 

  "ConfigFileReader" should "read config from file system" in {
    val reader = new ConfigFileReader(configFile)
    println(reader.rootConfig.getConfig("MyConfig"))
    assert( reader.rootConfig.getConfig("MyConfig").getString("testConfig") == "This is a test" )
  }

  it should "read config from TypeSafe Config default system property config.url" in {
    System.setProperty("config.url", configFile)
    val reader = new ConfigFileReader("")
    println(reader.rootConfig.getConfig("MyConfig"))
    assert( reader.rootConfig.getConfig("MyConfig").getString("testConfig") == "This is a test" )
  }
}