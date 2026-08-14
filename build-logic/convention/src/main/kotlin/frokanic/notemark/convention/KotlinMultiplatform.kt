package frokanic.notemark.convention

import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureKotlinMultiplatform() {
    configureKotlinMultiplatformAndroidLibrary()
    configureIosTargets()
    configureDesktopTarget()

    extensions.configure<KotlinMultiplatformExtension> {
        applyHierarchyTemplate()
    }
}
