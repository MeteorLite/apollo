plugins {
    id("kotlin")
    checkstyle
}

group = "org.apollo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(project(":cache"))
    compileOnly(project(":game"))
    compileOnly(project(":net"))
    compileOnly(project(":util"))

    implementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = "5.9.0")
    implementation(group = "org.junit.jupiter", name = "junit-jupiter-params", version = "5.9.0")

    api(group = "io.mockk", name = "mockk", version = "1.7.15")
    implementation(group = "org.assertj", name = "assertj-core", version = "3.23.1")
    implementation(group = "com.willowtreeapps.assertk", name = "assertk", version = "0.25")

    implementation(group = "org.powermock", name = "powermock-module-junit4", version = "2.0.9")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    kotlinOptions {
        jvmTarget = "17"
        apiVersion = "1.7"
        languageVersion = "1.7"
        freeCompilerArgs = listOf("-Xuse-k2")
    }
}