/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Gradle plugin project to get you started.
 * For more details on writing Custom Plugins, please refer to https://docs.gradle.org/8.4/userguide/custom_plugins.html in the Gradle documentation.
 */

plugins {
    // Apply the Java Gradle plugin development plugin to add support for developing Gradle plugins
    `java-gradle-plugin`

    // Apply the Kotlin JVM plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.9.10"

    id("com.gradle.plugin-publish") version "1.2.1"
}

description = "Static code analysis for Kotlin projects."
group = "io.github.aedenj.gradle.plugin.quality"
version = "1.0"

gradlePlugin {
    website.set("https://github.com/aedenj/kotlin-quality-plugin")
    vcsUrl.set("https://github.com/aedenj/kotlin-quality-plugin")
    plugins {
        create("kotlin-quality-plugin") {
            id = project.group.toString()
            implementationClass = "io.github.aedenj.gradle.plugin.quality.QualityPlugin"
            displayName = project.description
            description = project.description
            tags.set(listOf("kotlin", "quality", "ktlint", "detekt", "kover"))
        }
    }
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use the Kotlin JUnit 5 integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

gradlePlugin {
    // Define the plugin
    val greeting by plugins.creating {
        id = "kotlin.quality.plugin.greeting"
        implementationClass = "kotlin.quality.plugin.KotlinQualityPlugin"
    }
}

// Add a source set for the functional test suite
val functionalTestSourceSet = sourceSets.create("functionalTest") {
}

configurations["functionalTestImplementation"].extendsFrom(configurations["testImplementation"])
configurations["functionalTestRuntimeOnly"].extendsFrom(configurations["testRuntimeOnly"])

// Add a task to run the functional tests
val functionalTest by tasks.registering(Test::class) {
    testClassesDirs = functionalTestSourceSet.output.classesDirs
    classpath = functionalTestSourceSet.runtimeClasspath
    useJUnitPlatform()
}

gradlePlugin.testSourceSets.add(functionalTestSourceSet)

tasks.named<Task>("check") {
    // Run the functional tests as part of `check`
    dependsOn(functionalTest)
}

tasks.named<Test>("test") {
    // Use JUnit Jupiter for unit tests.
    useJUnitPlatform()
}
