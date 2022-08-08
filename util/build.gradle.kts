plugins {
    java
    kotlin("jvm")
    checkstyle
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(group = "io.netty", name = "netty-all", version = "4.1.79.Final")
    implementation(group = "com.google.guava", name = "guava", version = "31.1-jre")
    implementation(group = "org.apache.commons", name = "commons-compress", version = "1.21")
    implementation(group = "org.bouncycastle", name = "bcprov-jdk15on", version = "1.70")

    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = "5.9.0")
    testImplementation(
            group = "org.junit.jupiter",
            name = "junit-jupiter-engine",
            version = "5.9.0"
    )
    testImplementation(
            group = "org.junit.vintage",
            name = "junit-vintage-engine",
            version = "5.9.0"
    )
    testImplementation(
            group = "org.junit.platform",
            name = "junit-platform-launcher",
            version = "1.9.0"
    )
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