plugins {
    java
    id("org.jetbrains.kotlin.jvm")
    checkstyle
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":cache"))
    implementation(project(":net"))
    implementation(project(":util"))

    implementation(group = "org.jetbrains.kotlin", name = "kotlin-stdlib-jdk8", version = "1.7.10")
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-scripting-common", version = "1.7.10")
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-script-runtime", version = "1.7.10")
    implementation(group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-core", version = "1.6.4")
    implementation(group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-jdk8", version = "1.6.4")

    implementation(group = "io.netty", name = "netty-all", version = "4.1.79.Final")
    implementation(group = "com.google.guava", name = "guava", version = "31.1-jre")
    implementation(group = "com.lambdaworks", name = "scrypt", version = "1.4.0")
    implementation(group = "io.github.classgraph", name = "classgraph", version = "4.8.149")

    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = "5.9.0")
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-engine", version = "5.9.0")
    testImplementation(group = "org.junit.vintage", name = "junit-vintage-engine", version = "5.9.0")
    testImplementation(group = "org.junit.platform", name = "junit-platform-launcher", version = "1.9.0")

    testImplementation(group = "junit", name = "junit", version = "4.13.2")
    testImplementation(group = "org.powermock", name = "powermock-module-junit4", version = "2.0.9")
    testImplementation(group = "org.powermock", name = "powermock-api-mockito2", version = "2.0.9")
    testImplementation(group = "org.assertj", name = "assertj-core", version = "3.23.1")

    project(":game:plugins").dependencyProject.subprojects.forEach { pluginProject ->
        if (pluginProject.buildFile.exists()) {
            runtimeOnly(pluginProject)
        }
    }
}

tasks.test {
    useJUnitPlatform()
    jvmArgs = listOf("--add-opens=java.logging/java.util.logging=ALL-UNNAMED")
    classpath += configurations.runtimeClasspath.get()
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
        //freeCompilerArgs = listOf("-Xuse-k2")
    }
}