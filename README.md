# Kotlin Quality Gradle Plugin (Under Development)
[![License](https://img.shields.io/badge/license-MIT-blue.svg?style=flat)](http://www.opensource.org/licenses/MIT)
[![Build](https://github.com/aedenj/kotlin-quality-plugin/actions/workflows/build.yml/badge.svg)](https://github.com/aedenj/kotlin-quality-plugin/actions/workflows/build.yml)
[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)

Static code analysis for Kotlin projects using common quality plugins. This plugin provides unified console 
output for all quality plugins, which greatly simplifies a developer's
workflow. The following quality plugins are applied:

 * [Ktlint Plugin](https://github.com/JLLeitschuh/ktlint-gradle/tree/main) - If you don't configure the plugin, 
   then defaults defined in the [KtlintExtension](https://github.com/JLLeitschuh/ktlint-gradle/blob/main/plugin/src/main/kotlin/org/jlleitschuh/gradle/ktlint/KtlintExtension.kt) object will be used. 

Features:
* Zero configuration by default: opinionated configs are applied to all quality plugins
    - Default configuration files may be customized
* Complete console output for all quality plugins


## Setup
The quickest way to get started is to apply the plugin to your project's build file via the 
[Gradle's plugins DSL](https://docs.gradle.org/current/userguide/plugins.html#sec:plugins_block):
<details open>
<summary>Kotlin</summary>

```kotlin
plugins {
  id("io.github.aedenj.gradle.plugins.kotlin-quality")
}
```
</details>
<details>
<summary>Groovy</summary>

```groovy
plugins {
    id 'io.github.aedenj.gradle.plugins.kotlin-quality'
}
```
</details>

