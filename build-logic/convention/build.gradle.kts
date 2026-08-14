import org.gradle.kotlin.dsl.`kotlin-dsl`
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.frokanic.convention.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.composeCompiler.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.kotlin.serialization.gradlePlugin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "com.frokanic.convention.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidComposeApplication") {
            id = "com.frokanic.convention.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("kmpLibrary") {
            id = "com.frokanic.convention.kmp.library"
            implementationClass = "KmpLibraryConventionPlugin"
        }
        register("kmpWeb") {
            id = "com.frokanic.convention.kmp.web"
            implementationClass = "KmpWebConventionPlugin"
        }
        register("cmpLibrary") {
            id = "com.frokanic.convention.cmp.library"
            implementationClass = "CmpLibraryConventionPlugin"
        }
        register("cmpFeature") {
            id = "com.frokanic.convention.cmp.feature"
            implementationClass = "CmpFeatureConventionPlugin"
        }
        register("room") {
            id = "com.frokanic.convention.room"
            implementationClass = "RoomConventionPlugin"
        }
    }
}