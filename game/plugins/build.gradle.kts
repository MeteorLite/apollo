plugins {
    id("org.jetbrains.kotlin.jvm")
    id("kotlin")
}

repositories {
    mavenCentral()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    kotlinOptions {
        jvmTarget = "17"
        apiVersion = "1.7"
        languageVersion = "1.7"
        //freeCompilerArgs = listOf("-Xallow-unstable-dependencies")
        freeCompilerArgs = listOf(
                "-Xuse-k2",
                "-Xallow-any-scripts-in-source-roots"
        ) //k2 breaks plugin class generation
    }
}

configure(subprojects.filter { it.buildFile.exists() }) {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "java")
    apply(plugin = "checkstyle")

    sourceSets {
        main {
            kotlin {
                srcDir("src")
            }
        }
        test {
            kotlin {
                srcDir("test")
            }
        }
    }

    apply {
        repositories {
            mavenCentral()
        }



        dependencies {
            implementation(group = "com.google.guava", name = "guava", version = "31.1-jre")

            testImplementation(
                    group = "org.junit.jupiter",
                    name = "junit-jupiter-api",
                    version = "5.9.0"
            )
            testImplementation(
                    group = "org.junit.jupiter",
                    name = "junit-jupiter-params",
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

            testImplementation(project(":game:plugin-testing"))
        }

        tasks.getByName<Test>("test") {
            useJUnitPlatform()
        }

        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
            kotlinOptions {
                jvmTarget = "17"
                apiVersion = "1.7"
                languageVersion = "1.7"
                freeCompilerArgs =
                        listOf("-Xallow-unstable-dependencies", "-Xallow-any-scripts-in-source-roots")
                //freeCompilerArgs = listOf("-Xuse-k2") //k2 breaks plugin class generation
            }
        }
    }
}