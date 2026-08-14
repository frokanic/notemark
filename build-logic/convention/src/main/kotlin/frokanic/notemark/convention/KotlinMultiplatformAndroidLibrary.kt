package frokanic.notemark.convention

import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryExtension
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureKotlinMultiplatformAndroidLibrary() {
    extensions.configure<KotlinMultiplatformExtension> {
        (this as ExtensionAware).extensions.configure<KotlinMultiplatformAndroidLibraryExtension> {
            namespace = this@configureKotlinMultiplatformAndroidLibrary.pathToPackageName()
            compileSdk = libs.findVersion("projectCompileSdkVersion").get().toString().toInt()
            minSdk = libs.findVersion("projectMinSdkVersion").get().toString().toInt()

            androidResources.enable = true

            withHostTestBuilder { }

            withDeviceTestBuilder {
                sourceSetTreeName = "test"
            }.configure {
                instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
        }
    }
}
