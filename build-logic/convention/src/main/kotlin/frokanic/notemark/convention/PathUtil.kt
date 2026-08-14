package frokanic.notemark.convention

import org.gradle.api.Project
import java.util.Locale

fun Project.pathToPackageName(): String {
    val relativePackageName = path
        .replace(':', '.')
        .lowercase()

    return "com.frokanic.notemark$relativePackageName"
}

fun Project.pathToFrameworkName(): String {
    val parts = path.split(":", "-", "_", " ")
    return parts.joinToString("") { part ->
        part.replaceFirstChar { it.titlecase(Locale.ROOT) }
    }
}
