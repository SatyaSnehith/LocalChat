package com.satyasnehith.localhost.core.chatserver
import com.satyasnehith.localhost.core.chatserver.config.configureHTTP
import com.satyasnehith.localhost.core.chatserver.config.configureMonitoring
import com.satyasnehith.localhost.core.chatserver.config.configureRouting
import com.satyasnehith.localhost.core.chatserver.config.configureSecurity
import com.satyasnehith.localhost.core.chatserver.config.configureSerialization
import com.satyasnehith.localhost.core.chatserver.config.configureSockets
import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty


fun Application.module() {
    configureSecurity()
    configureSerialization()
    configureMonitoring()
    configureHTTP()
    configureSockets()
    configureRouting()
}


fun server() {
    embeddedServer(
        factory = Netty,
        port = 8080,
        host = "0.0.0.0",
        module = Application::module
    )
        .start(wait = true)

}
