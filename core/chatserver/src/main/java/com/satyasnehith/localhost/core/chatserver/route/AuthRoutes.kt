package com.satyasnehith.localhost.core.chatserver.route

import com.auth0.jwt.JWT
import com.satyasnehith.localhost.core.chatserver.model.User
import com.satyasnehith.localhost.core.chatserver.service.AuthService
import io.ktor.server.application.Application
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import io.ktor.util.reflect.TypeInfo

fun Application.authRoutes() = routing {
    post("/login") {
        val authService = AuthService()

        val user = call.receive<User>()

        call.respond(
            hashMapOf("token" to authService.generateToken(user.username)),
        )
    }
}