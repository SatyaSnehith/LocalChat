package com.satyasnehith.localhost.core.chatserver.config

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respondText

fun Application.installPlugins() {
    installStatusPages()
}

fun Application.installStatusPages() {
    install(StatusPages) {
        exception<IllegalStateException> { call, cause ->
            call.respondText("App in illegal state as ${cause.message}")
        }
    }
}

