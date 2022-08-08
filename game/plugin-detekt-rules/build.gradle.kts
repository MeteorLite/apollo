plugins {
    kotlin("jvm")
    checkstyle
}

group = "apollo"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    api(group = "io.gitlab.arturbosch.detekt", name = "detekt-api", version = "1.21.0")
    api(group = "org.jetbrains.kotlin", name = "kotlin-stdlib-jdk8")

    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = "5.9.0")
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-params", version = "5.9.0")
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-engine", version = "5.9.0")
    testImplementation(group = "org.junit.platform", name = "junit-platform-launcher", version = "1.9.0")

    testImplementation(group = "io.gitlab.arturbosch.detekt", name = "detekt-test", version = "1.21.0")
}