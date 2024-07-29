import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    id("com.vanniktech.maven.publish") version "0.29.0"
}

group = "pe.devs.kmp.formvalidations"
version = "1.0"

kotlin {
    androidTarget {
        publishLibraryVariants("release")
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    jvm()

    js {
        browser {
            webpackTask {
                mainOutputFileName = "formvalidations.js"
            }
        }
        binaries.executable()
    }

    wasmJs {
        browser()
        binaries.executable()
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "formvalidations"
            isStatic = true
        }
    }

    listOf(
        macosX64(),
        macosArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "formvalidations"
            isStatic = true
        }
    }

    linuxX64 {
        binaries.staticLib {
            baseName = "formvalidations"
        }
    }


    mingwX64 {
        binaries.staticLib {
            baseName = "formvalidations"
        }
    }

    sourceSets {
        commonMain.dependencies {
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

    }

    //https://kotlinlang.org/docs/native-objc-interop.html#export-of-kdoc-comments-to-generated-objective-c-headers
    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        compilations["main"].compilerOptions.options.freeCompilerArgs.add("-Xexport-kdoc")
    }

}

android {
    namespace = "pe.devs.kmp.formvalidations"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}


mavenPublishing {

    coordinates("pe.devs.kmp", "formvalidations", "1.0.0")

    pom {
        name.set("Form & Validations")
        description.set("Form & Validations")
        inceptionYear.set("2024")
        url.set("https://github.com/devsstudio/kmp-form-validations/")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("devsstudio")
                name.set("Devs Studio")
                url.set("https://github.com/devsstudio/")
            }
        }
        scm {
            url.set("https://github.com/devsstudio/kmp-form-validations/")
            connection.set("scm:git:git://github.com/devsstudio/kmp-form-validations.git")
            developerConnection.set("scm:git:ssh://git@github.com/devsstudio/kmp-form-validations.git")
        }
    }

    // Configure publishing to Maven Central
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    // Enable GPG signing for all publications
    signAllPublications()
}