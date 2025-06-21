
plugins {
    alias(libs.plugins.localchat.android.library)
    alias(libs.plugins.localchat.android.library.jacoco)
    alias(libs.plugins.localchat.hilt)
}

android {
    defaultConfig {
        consumerProguardFiles("consumer-proguard-rules.pro")
    }
    namespace = "com.satyasnehith.localchat.core.datastore"
}

dependencies {
    api(libs.androidx.dataStore)

    testImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(libs.androidx.test.ext)

}
