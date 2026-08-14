import frokanic.notemark.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class RoomConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.devtools.ksp")
            }

            dependencies {
                "commonMainApi"(libs.findLibrary("androidx-room-runtime").get())
                "commonMainApi"(libs.findLibrary("androidx-sqlite-bundled").get())

                "kspAndroid"(libs.findLibrary("androidx-room-compiler").get())
                "kspIosArm64"(libs.findLibrary("androidx-room-compiler").get())
                "kspIosSimulatorArm64"(libs.findLibrary("androidx-room-compiler").get())
                "kspJvm"(libs.findLibrary("androidx-room-compiler").get())
            }
        }
    }

}
