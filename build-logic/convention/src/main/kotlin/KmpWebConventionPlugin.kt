import frokanic.notemark.convention.configureWebTargets
import org.gradle.api.Plugin
import org.gradle.api.Project

class KmpWebConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.multiplatform")
            }

            configureWebTargets()
        }
    }

}
