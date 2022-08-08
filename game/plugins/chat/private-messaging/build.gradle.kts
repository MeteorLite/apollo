plugins {
    kotlin("jvm")
}

group = "apollo"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":util"))
    implementation(project(":cache"))
    implementation(project(":game"))
    implementation(project(":net"))

    testImplementation(project(":game:plugin-testing"))
}