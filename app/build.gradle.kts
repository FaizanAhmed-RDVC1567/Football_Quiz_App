import java.io.ByteArrayOutputStream

/*
Function to count total commits (used as an automated Version Code).
Needs to use Gradle's Project interface rather than being standalone
detached functions
*/
fun Project.getGitCommitCount(): Int {
    return try {
        val stdout = ByteArrayOutputStream()
        providers.exec {
            commandLine("git", "rev-list", "--count", "HEAD")
            standardOutput = stdout
        }.result.get() // Forces execution synchronously
        stdout.toString().trim().toInt()
    } catch (e: Exception) {
        1 // Fallback if Git is missing or not initialised
    }
}

// Function to get the short Git commit hash (7 hex characters)
fun Project.getGitCommitHash(): String {
    return try {
        val stdout = ByteArrayOutputStream()
        providers.exec {
            commandLine("git", "rev-parse", "--short", "HEAD")
            standardOutput = stdout
        }.result.get()  // Forces execution synchronously
        stdout.toString().trim()
    } catch (e: Exception) {
        "unknown" // Fallback
    }
}

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.faizanahmed.footybrain"
    compileSdk {
        version = release(37) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.faizanahmed.footybrain"
        minSdk = 28
        targetSdk = 36
        versionCode = 1  // Here the function call 'getGitCommitCount()' will be called and assigned
        versionName = "0.1.0" // Here, after the last digit, 'getGitCommitHash()' will be called inside braces

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // Compose BOM
    implementation(platform(libs.androidx.compose.bom))

    // Activity Compose
    implementation(libs.androidx.activity.compose)

    // Navigation Compose
    implementation(libs.androidx.navigation.compose)

    // Compose UI modules (version controlled by BOM)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)

    // Lifecycle ViewModel Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // DataStore
    implementation(libs.androidx.datastore.preferences)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
}