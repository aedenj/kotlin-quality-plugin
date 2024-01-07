package io.github.aedenj.gradle.plugins

import org.assertj.core.api.Assertions.assertThat
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestInstance
import kotlin.test.Test

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("given a gradle project when the kotlin quality plugin is applied")
class KotlinQualityPluginTest {
    private lateinit var project: Project

    @BeforeAll
    fun setup() {
        project = ProjectBuilder.builder().build()
        assertThat(project.plugins).isEmpty()
        project.plugins.apply("io.github.aedenj.gradle.plugins.kotlin-quality")
    }

    @Test
    @DisplayName("then ktlint gradle plugin is applied")
    fun `then ktlint gradle plugin is applied `() {
        assertThat(project.pluginManager.hasPlugin("org.jlleitschuh.gradle.ktlint")).isTrue()
    }

    @Test
    @DisplayName("then kover gradle plugin is applied")
    fun `then kover gradle plugin is applied `() {
        assertThat(project.pluginManager.hasPlugin("org.jetbrains.kotlinx.kover")).isTrue()
    }
}
