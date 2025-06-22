package com.satyasnehith.localhost.core.chatserver.route

import io.ktor.server.application.Application
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.userRoutes() = routing {
    get("/") {
        call.respondText("Hello World!")
    }
}