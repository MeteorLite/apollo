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
    implementation(project(":game:plugins:entity:pathing"))
    implementation(project(":game:plugins:entity:actions"))

    testImplementation(project(":game:plugin-testing"))
}