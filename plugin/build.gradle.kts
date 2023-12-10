import com.adarshr.gradle.testlogger.theme.ThemeType

/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Gradle plugin project to get you started.
 * For more details on writing Custom Plugins, please refer to https://docs.gradle.org/8.4/userguide/custom_plugins.html in the Gradle documentation.
 */

plugins {
    `kotlin-dsl`

    // Apply the Java Gradle plugin development plugin to add support for developing Gradle plugins
    // https://docs.gradle.org/current/userguide/java_gradle_plugin.html
    `java-gradle-plugin`

    // Apply the Kotlin JVM plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.9.21"

    // https://plugins.gradle.org/plugin/com.adarshr.test-logger
    id("com.adarshr.test-logger") version "4.0.0"

    // https://github.com/JLLeitschuh/ktlint-gradle
    id("org.jlleitschuh.gradle.ktlint") version "12.0.2"

    // https://plugins.gradle.org/docs/publish-plugin
    id("com.gradle.plugin-publish") version "1.2.1"
}

description = "Static code analysis for Kotlin projects."
group = "io.github.aedenj.gradle.plugins.kotlin-quality"
version = "1.0"

gradlePlugin {
    website.set("https://github.com/aedenj/kotlin-quality-plugin")
    vcsUrl.set("https://github.com/aedenj/kotlin-quality-plugin")
    plugins {
        create("kotlin-quality-plugin") {
            id = project.group.toString()
            implementationClass = "io.github.aedenj.gradle.plugins.KotlinQualityPlugin"
            displayName = project.description
            description = project.description
            tags.set(listOf("kotlin", "quality", "ktlint", "detekt", "kover"))
        }
    }
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

publishing {
    repositories {
        maven {
            name = "localPluginRepository"
            url = uri("../local-plugin-repository")
        }
    }
}

dependencies {
    listOf(
        libs.ktlint.plugin,
    ).forEach { implementation(it) }

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    listOf(
        "org.jetbrains.kotlin:kotlin-test-junit5",
        libs.junit5.params,
        libs.assertj.core,
        gradleTestKit(),
    ).forEach { testImplementation(it) }
}

tasks {
    test {
        useJUnitPlatform()
        jvmArgs = listOf("-Duser.language=en")

        testlogger {
            theme = ThemeType.MOCHA
            slowThreshold = 5000
            showStandardStreams = true
            showFullStackTraces = false
            logLevel = LogLevel.QUIET
        }
    }
}
