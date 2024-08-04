package io.github.aedenj.gradle.plugins

import org.assertj.core.api.Assertions.assertThat
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import kotlin.test.Test

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("given a project when applying the quality plugin")
class PluginRegistrationTest {
    private lateinit var project: Project

    @BeforeAll
    fun setup() {
        project = ProjectBuilder.builder().build()
        assertThat(project.plugins).isEmpty()
        project.plugins.apply("io.github.aedenj.gradle.plugins.kotlin-quality")
    }

    @Test
    @DisplayName("then the ktlint gradle plugin is applied")
    fun `then ktlint gradle plugin is applied `() {
        assertThat(project.pluginManager.hasPlugin("org.jlleitschuh.gradle.ktlint")).isTrue()
    }

    @Test
    @DisplayName("then the kover gradle plugin is applied")
    fun `then kover gradle plugin is applied `() {
        assertThat(project.pluginManager.hasPlugin("org.jetbrains.kotlinx.kover")).isTrue()
    }
}
