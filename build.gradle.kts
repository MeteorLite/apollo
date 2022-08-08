plugins {
    kotlin("jvm") version "1.7.20-Beta"
    checkstyle
}

repositories {
    mavenCentral()
}

group = "org.apollo"
version = "1.0-SNAPSHOT"

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    kotlinOptions {
        jvmTarget = "17"
        apiVersion = "1.7"
        languageVersion = "1.7"
        freeCompilerArgs = listOf("-Xuse-k2")
    }
}

configure(subprojects.filter { it.buildFile.exists() }) {
    apply {
        tasks.withType<Checkstyle>().all {
            outputs.upToDateWhen {
                false
            }
            checkstyle {
                toolVersion = "10.3.2"
            }
        }
    }
}

