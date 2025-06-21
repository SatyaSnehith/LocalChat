plugins {
    alias(libs.plugins.localchat.android.library)
    alias(libs.plugins.localchat.android.library.jacoco)
    alias(libs.plugins.localchat.android.room)
    alias(libs.plugins.localchat.hilt)
}

android {
    namespace = "com.satyasnehith.localchat.core.database"
}

dependencies {

    implementation(libs.kotlinx.datetime)

    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.kotlinx.coroutines.test)
}
