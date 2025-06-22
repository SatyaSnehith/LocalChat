package com.satyasnehith.localhost.core.chatserver.service

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import java.security.SecureRandom
import java.util.Base64
import java.util.Date
import kotlin.time.Duration.Companion.minutes

class AuthService(
    val jwtSecret: String = generateSecureSecret(),
    val jwtDomain: String = "http://localhost:8080/",
    val jwtIssuer: String = "local chat",
    val jwtRealm: String = "Access to local chat",
    val jwtAudience: String = "local-chat-users",
    val tokenExpiryMs: Long = 30.minutes.inWholeMinutes
) {
    fun generateToken(username: String): String {
        return JWT.create()
            .withAudience(jwtAudience)
            .withIssuer(jwtIssuer)
            .withClaim("username", username)
            .withExpiresAt(Date(System.currentTimeMillis() + tokenExpiryMs))
            .sign(Algorithm.HMAC256(jwtSecret))
    }

    fun isValidUser(username: String, password: String): Boolean {
        // For dev: dummy check
        return username == "admin" && password == "password"
    }

    companion object {
        fun generateSecureSecret(): String {
            val random = SecureRandom()
            val keyBytes = ByteArray(32) // 256-bit key
            random.nextBytes(keyBytes)
            return Base64.getEncoder().encodeToString(keyBytes)
        }
    }
}
