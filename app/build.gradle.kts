plugins {
    alias(libs.plugins.localchat.android.application)
    alias(libs.plugins.localchat.android.application.compose)
    alias(libs.plugins.localchat.android.application.jacoco)
//    alias(libs.plugins.localchat.android.application.firebase)
    alias(libs.plugins.localchat.hilt)
    id("com.google.android.gms.oss-licenses-plugin")
    alias(libs.plugins.roborazzi)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.satyasnehith.localchat"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.satyasnehith.localchat"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    // Due to https://github.com/Kotlin/kotlinx.coroutines/issues/2023
    packaging {
        resources.excludes.addAll(
            arrayOf(
                "META-INF/AL2.0",
                "META-INF/licenses/*",
                "**/attach_hotspot_windows.dll",
                "META-INF/INDEX.LIST",
                "META-INF/io.netty.versions.properties",
            )
        )

    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.websockets)
    implementation(libs.ktor.server.status.pages)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


}
