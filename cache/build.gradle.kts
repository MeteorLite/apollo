plugins {
    java
    id("org.jetbrains.kotlin.jvm")
    checkstyle
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":util"))
    implementation(group = "com.google.guava", name = "guava", version = "31.1-jre")
    implementation(group = "io.netty", name = "netty-all", version = "4.1.79.Final")
}


tasks.test {
    useJUnitPlatform()
}

tasks.compileJava {
    sourceCompatibility = JavaVersion.VERSION_17.toString()
    targetCompatibility = JavaVersion.VERSION_17.toString()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    kotlinOptions {
        jvmTarget = "17"
        apiVersion = "1.7"
        languageVersion = "1.7"
        freeCompilerArgs = listOf("-Xuse-k2")
    }
}