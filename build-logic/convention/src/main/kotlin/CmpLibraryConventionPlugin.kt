import frokanic.notemark.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class CmpLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.frokanic.convention.kmp.library")
                apply("com.frokanic.convention.kmp.web")
                apply("org.jetbrains.compose")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            dependencies {
                "commonMainImplementation"(libs.findLibrary("compose-runtime").get())
                "commonMainImplementation"(libs.findLibrary("compose-foundation").get())
                "commonMainImplementation"(libs.findLibrary("compose-material3").get())
                "commonMainImplementation"(libs.findLibrary("compose-ui").get())
                "commonMainImplementation"(libs.findLibrary("compose-components-resources").get())
                "commonMainImplementation"(libs.findLibrary("compose-uiToolingPreview").get())

                "androidMainImplementation"(libs.findLibrary("compose-uiTooling").get())
                "androidRuntimeClasspath"(libs.findLibrary("compose-uiTooling").get())
            }
        }
    }

}
