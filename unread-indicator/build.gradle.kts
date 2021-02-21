plugins {
  id("com.android.library")
}

ext {
  set(PomKeys.artifactId, ReleaseConfig.artifactId)
  set(PomKeys.description, ReleaseConfig.description)
  set(PomKeys.name, ReleaseConfig.artifactName)
  set(PomKeys.versionName, ReleaseConfig.versionName)
}


android {
  compileSdkVersion(29)

  defaultConfig {
    minSdkVersion(16)
    targetSdkVersion(29)
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