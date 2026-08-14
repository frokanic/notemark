import frokanic.notemark.convention.configureKotlinMultiplatform
import frokanic.notemark.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class KmpLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.kotlin.multiplatform.library")
                apply("com.android.lint")
                apply("org.jetbrains.kotlin.multiplatform")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            configureKotlinMultiplatform()

            dependencies {
                "commonMainImplementation"(libs.findLibrary("kotlin-stdlib").get())
                "commonMainImplementation"(libs.findLibrary("kotlinx-serialization-json").get())

                "commonTestImplementation"(libs.findLibrary("kotlin-test").get())
                "commonTestImplementation"(libs.findLibrary("kotlinx-coroutines-test").get())
                "commonTestImplementation"(libs.findLibrary("turbine").get())

                "androidDeviceTestImplementation"(libs.findLibrary("androidx-core").get())
                "androidDeviceTestImplementation"(libs.findLibrary("androidx-runner").get())
                "androidDeviceTestImplementation"(libs.findLibrary("androidx-testExt-junit").get())
            }
        }
    }

}
