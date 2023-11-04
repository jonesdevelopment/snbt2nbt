plugins {
  id("java")
  id("com.github.johnrengelman.shadow") version "8.1.1"
}

apply(plugin = "java")
apply(plugin = "com.github.johnrengelman.shadow")

repositories {
  mavenCentral() // Lombok
}

dependencies {
  compileOnly("org.projectlombok:lombok:1.18.30")
  annotationProcessor("org.projectlombok:lombok:1.18.30")

  testCompileOnly("org.projectlombok:lombok:1.18.30")
  testAnnotationProcessor("org.projectlombok:lombok:1.18.30")

  val adventureVersion = "4.14.0"

  // adventure nbt
  implementation("net.kyori:adventure-nbt:$adventureVersion")
}

java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8

tasks {
  sourceSets {
    main {
      java {
        srcDirs.add(File("src/main/java"))
      }
    }
  }

  compileJava {
    options.encoding = "UTF-8"
  }

  shadowJar {
    archiveFileName.set("${rootProject.name}-${version}-SNAPSHOT.jar")
    from(sourceSets["main"].allJava) // Include all Java source files
  }

  // This is a small wrapper tasks to simplify the building process
  register("build-snbt2nbt") {
    dependsOn(clean, shadowJar)
  }
}
