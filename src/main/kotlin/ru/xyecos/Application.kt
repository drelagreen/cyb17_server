package ru.xyecos

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.cors.routing.*
import ru.xyecos.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module).start(wait = true)
}

fun Application.module() {
    install(CORS) {
        HttpMethod.DefaultMethods.forEach {
            allowMethod(it)
        }
        allowHeaders { true }
        allowHeader(HttpHeaders.AccessControlAllowOrigin)
        allowHeader(HttpHeaders.ContentType)
        anyHost()
    }
    configureHTTP()
    configureMonitoring()
    configureSerialization()
    configureSockets()
//    configureSecurity()
    configureRouting()
}
