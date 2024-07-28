plugins {
    alias(libs.plugins.multiplatform).apply(false)
    alias(libs.plugins.android.library).apply(false)
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
}
