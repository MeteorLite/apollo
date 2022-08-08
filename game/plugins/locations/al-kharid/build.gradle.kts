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
    implementation(project(":game:plugins:entity:spawn"))
    implementation(project(":game:plugins:shops"))

    testImplementation(project(":game:plugin-testing"))
}