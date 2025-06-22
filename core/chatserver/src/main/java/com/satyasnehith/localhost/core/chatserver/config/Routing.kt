package com.satyasnehith.localhost.core.chatserver.config

import com.satyasnehith.localhost.core.chatserver.route.authRoutes
import com.satyasnehith.localhost.core.chatserver.route.userRoutes
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    userRoutes()
    authRoutes()
}
