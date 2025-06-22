package com.satyasnehith.localhost.core.chatserver.config

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.satyasnehith.localhost.core.chatserver.service.AuthService
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import java.security.SecureRandom
import java.util.Base64




fun Application.configureSecurity() {
    val authService = AuthService()

    authentication {
        jwt {
            realm = authService.jwtRealm
            verifier(
                JWT
                    .require(Algorithm.HMAC256(authService.jwtSecret))
                    .withAudience(authService.jwtAudience)
                    .withIssuer(authService.jwtDomain)
                    .build()
            )
            validate { credential ->
                if (credential.payload.audience.contains(authService.jwtAudience)) JWTPrincipal(credential.payload) else null
            }
        }
    }
}
