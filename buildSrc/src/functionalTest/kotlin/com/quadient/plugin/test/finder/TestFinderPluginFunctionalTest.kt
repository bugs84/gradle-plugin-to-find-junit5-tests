/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.quadient.plugin.test.finder

import java.io.File
import org.gradle.testkit.runner.GradleRunner
import kotlin.test.Test
import kotlin.test.assertTrue

/**
 * A simple functional test for the 'com.quadient.plugin.test.finder.greeting' plugin.
 */
class TestFinderPluginFunctionalTest {
    @Test fun `can run task`() {
        // Setup the test build
        val projectDir = File("build/functionalTest")
        projectDir.mkdirs()
        projectDir.resolve("settings.gradle").writeText("")
        projectDir.resolve("build.gradle").writeText("""
            plugins {
                id('com.quadient.plugin.test.finder.greeting')
            }
        """)

        // Run the build
        val runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments("greeting")
        runner.withProjectDir(projectDir)
        val result = runner.build();

        // Verify the result
        assertTrue(result.output.contains("Hello from plugin 'com.quadient.plugin.test.finder.greeting'"))
    }
}
