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
    implementation(libs.ktor.server.call.logging)
    implementation(libs.ktor.server.auth)
    implementation(libs.ktor.server.auth.jwt){
        exclude(group = "com.auth0", module = "jwks-rsa")
    }
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.server.partial.content)
    implementation(libs.ktor.server.default.headers)
    implementation(libs.ktor.server.websockets)
//    implementation(libs.logback.classic)
    implementation(libs.timber  )

    testImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(libs.androidx.test.ext)

}
