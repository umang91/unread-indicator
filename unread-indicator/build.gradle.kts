import java.io.FileInputStream
import java.util.*

plugins {
  id("com.android.library")
}

android {
  compileSdk = 30

  defaultConfig {
    minSdk = 21
    targetSdk = 30
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