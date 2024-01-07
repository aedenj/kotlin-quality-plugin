package io.github.aedenj.gradle.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.jlleitschuh.gradle.ktlint.KtlintPlugin

/**
 *
 * @author Aeden Jameson
 * @since 01.06.2024
 * @see KtlintPlugin
 */
class KotlinQualityPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            apply<KtlintPlugin>()
        }
    }
}
