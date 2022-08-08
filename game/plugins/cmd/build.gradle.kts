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
    implementation(project(":game:plugins:api"))

    testImplementation(project(":game:plugin-testing"))
    testImplementation(
            group = "org.jetbrains.kotlin",
            name = "kotlin-script-runtime",
            version = "1.7.10"
    )
}