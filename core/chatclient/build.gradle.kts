plugins {
    alias(libs.plugins.localchat.android.library)
    alias(libs.plugins.localchat.android.library.jacoco)
    alias(libs.plugins.localchat.hilt)
}

android {
    namespace = "com.satyasnehith.localchat.core.chatclient"
}

dependencies {

    testImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(libs.androidx.test.ext)

}
