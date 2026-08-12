rootProject.name = "NoteMark"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

include(":androidApp")
include(":desktopApp")
include(":shared")
include(":webApp")
include(":core:domain")
include(":core:common")
include(":core:presentation")
include(":core:data")
include(":core:designsystem")
include(":core:network")
include(":core:database")
include(":feature:auth:domain")
include(":feature:auth:presentation")
include(":feature:notes:data")
include(":feature:notes:domain")
include(":feature:notes:presentation")
include(":feature:settings:data")
include(":feature:settings:domain")
include(":feature:settings:presentation")
