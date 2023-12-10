package io.github.aedenj.gradle.plugins

import org.assertj.core.api.Assertions.assertThat
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test

@DisplayName("given the kotlin quality plugin applied to a project")
class KotlinQualityPluginTest {
    @Test
    @DisplayName("then the project contains contains the ktlint plugin")
    fun `contains required plugins`() {
        val project = ProjectBuilder.builder().build()

        assertThat(project.plugins).isEmpty()
        project.plugins.apply("io.github.aedenj.gradle.plugins.kotlin-quality")
        assertThat(project.pluginManager.hasPlugin("org.jlleitschuh.gradle.ktlint")).isTrue()
    }
}
