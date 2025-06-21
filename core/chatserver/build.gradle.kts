plugins {
    alias(libs.plugins.localchat.android.library)
    alias(libs.plugins.localchat.android.library.jacoco)
    alias(libs.plugins.localchat.hilt)
}

android {
    namespace = "com.satyasnehith.localchat.core.chatserver"
}

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.websockets)
    implementation(libs.ktor.server.status.pages)

    testImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(libs.androidx.test.ext)

}
