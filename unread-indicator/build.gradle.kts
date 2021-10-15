import java.io.FileInputStream
import java.util.*

plugins {
  id("com.android.library")
}

fun getVersionName(): String {
  val properties = Properties()
  properties.load(FileInputStream("./unread-indicator/gradle.properties"))
  return properties.getProperty("VERSION_NAME") ?: throw GradleException(
    "VERSION_NAME not found in ./unread-indicator/gradle.properties"
  )
}

android {
  compileSdk = 29

  defaultConfig {
    minSdk = 16
    targetSdk = 29
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
    }
  }
}

dependencies {
  implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
}

apply(plugin = "com.vanniktech.maven.publish")