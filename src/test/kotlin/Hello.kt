import org.junit.platform.engine.discovery.DiscoverySelectors
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder
import org.junit.platform.launcher.core.LauncherFactory
import java.nio.file.Path
import java.nio.file.Paths

//fun main() {
//    println("HHHHHHHHHHHHHEEEELLLLOOOOOOOOOOOOOOOOOOO in tests")
//
//
//    val toSet = mutableSetOf<Path>()
//
//            toSet.add(Paths.get("C:\\PRAC\\GradlePlugin\\ab-usage\\build\\classes\\kotlin\\test"))
//
//            val build = LauncherDiscoveryRequestBuilder.request()
//                    .selectors(DiscoverySelectors.selectClasspathRoots(toSet))
//                    .build()
//            val launcher = LauncherFactory.create()
//            val testPlan = launcher.discover(build)
//            val tests = testPlan.roots.flatMap { testPlan.getDescendants(it) } + testPlan.roots
//
//            println("Tests count '${tests.size}'")
//            tests.forEach { println("Test - $it") }
//
//}


fun main() {
    println("HHHHHHHHHHHHHEEEELLLLOOOOOOOOOOOOOOOOOOO in tests")


    val build = LauncherDiscoveryRequestBuilder.request()
            .selectors(DiscoverySelectors.selectPackage(""))
            .build()
    val launcher = LauncherFactory.create()
    val testPlan = launcher.discover(build)
    val tests = testPlan.roots.flatMap { testPlan.getDescendants(it) } + testPlan.roots

    println("Tests count '${tests.size}'")
    tests.forEach { println("Test - $it") }

}