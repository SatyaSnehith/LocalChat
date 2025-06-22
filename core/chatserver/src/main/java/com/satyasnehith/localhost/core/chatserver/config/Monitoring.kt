package com.satyasnehith.localhost.core.chatserver.config

import io.ktor.server.application.*
import io.ktor.server.logging.toLogString
import io.ktor.server.plugins.calllogging.*
import io.ktor.server.request.*
import io.ktor.server.response.responseType
import java.util.concurrent.TimeUnit
import org.slf4j.event.*
import timber.log.Timber

fun Application.configureMonitoring() {
    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
        format { call ->
            val status = call.response.status()?.value
            val uri = call.request.uri
            val method = call.request.httpMethod.value
            "HTTP $method - $uri -> $status"
        }

        logger = object : org.slf4j.Logger by org.slf4j.helpers.NOPLogger.NOP_LOGGER {
            override fun info(msg: String?) {
                Timber.i(msg)
            }

            override fun error(msg: String?) {
                Timber.e(msg)
            }

            override fun warn(msg: String?) {
                Timber.w(msg)
            }

            override fun debug(msg: String?) {
                Timber.d(msg)
            }

            override fun trace(msg: String?) {
                Timber.v(msg)
            }
        }
    }
    intercept(ApplicationCallPipeline.Monitoring) {
        proceed()

        val requestBody = call.request.toLogString()
        val responseStatus = call.response.status()
        val responseBody = call.response.responseType?.type

        val logText = buildString {
            appendLine("🔹 REQUEST ${call.request.httpMethod.value} ${call.request.uri}")
            appendLine("📥 Body:\n${requestBody}")

            appendLine("🔹 RESPONSE $responseStatus")
            appendLine("📤 Body:\n${responseBody}")
        }

        Timber.tag("Ktor-Full").i(logText)
    }
}
