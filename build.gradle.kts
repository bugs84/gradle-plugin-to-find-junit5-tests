import com.quadient.plugin.test.finder.TestFinderPlugin

/*
 * This file was generated by the Gradle 'init' task.
 *
 * This is a general purpose Gradle build.
 * Learn how to create Gradle builds at https://guides.gradle.org/creating-new-gradle-builds
 */
//buildscript {
////    repositories {
////        maven {
////            url = uri("C:/PRAC/GradlePlugin/ab-test-finder")
////        }
////    }
////    dependencies {
////        classpath("com.quadient.plugin.test.finder.greeting:test-finder:1.0-SNAPSHOT")
////    }
////}
////apply(plugin = "com.quadient.plugin.test.finder.greeting")


//open class GreetingPluginExtension {
//    var name = "John"
//}
//
//class GreetingPlugin : Plugin<Project> {
//
//    override fun apply(project: Project) {
//
//        val extension = project.extensions.create<GreetingPluginExtension>("greeting")
//
//        project.task("hello") {
//            doLast {
//                println("Hello ${extension.name} from the GreetingPlugin")
//            }
//        }
//
//        project.task("myTask1") {
//            doLast {
//                println("My Task 1 - good job.")
//            }
//        }
//    }
//
//}
//
//
//// Apply the plugin
//apply<GreetingPlugin>()
//
////the<GreetingPluginExtension>().name = "Mr mandator"
//
//configure<GreetingPluginExtension> {
//    name = "MrConfig"
//}


apply<TestFinderPlugin>()


//configurations.testCompileClasspath


plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.3.41"

    // Apply the application plugin to add support for building a CLI application.
    application
}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")


    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.5.2")

        //TODO Launcer in tests - should be just in plugin
        testImplementation(group = "org.junit.platform", name = "junit-platform-launcher", version = "1.5.2")
    }
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

application {
    // Define the main class for the application
    mainClassName = "cz.vondr.test.AppKt"
}
