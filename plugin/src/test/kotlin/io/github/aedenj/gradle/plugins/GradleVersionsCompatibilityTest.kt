package io.github.aedenj.gradle.plugins

import org.assertj.core.api.Assertions.assertThat
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.io.TempDir
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.File

@DisplayName("given a version of gradle ")
class GradleVersionsCompatibilityTest {
    @field:TempDir
    lateinit var projectDir: File

    private val buildFile by lazy { projectDir.resolve("build.gradle") }
    private val settingsFile by lazy { projectDir.resolve("settings.gradle") }

    @ValueSource(strings = ["7.6.3", "8.1", "8.2.1", "8.3", "8.4", "8.5"])
    @ParameterizedTest(name = "then the task succeeds for version {0}")
    @DisplayName("when the build task is run")
    fun `test gradle version compatibility`(version: String) {
        settingsFile.writeText("")
        buildFile.writeText(
            """
            plugins {
                id 'io.github.aedenj.gradle.plugins.kotlin-quality'
            }
            
            repositories {
                mavenCentral()
            }
            """.trimIndent(),
        )

        val result =
            GradleRunner.create()
                .withProjectDir(projectDir)
                .withGradleVersion(version)
                .withPluginClasspath()
                .withArguments("build", "--stacktrace")
                .build()

        assertThat(result.task(":buildEnvironment")?.outcome).isEqualTo(TaskOutcome.SUCCESS)
    }
}
