package org.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import org.example.routes.authRoutes
fun main() {

    val port = System.getenv("PORT")?.toInt() ?: 8080

    embeddedServer(Netty, port = port) {

        install(ContentNegotiation) {
            json()
        }

        routing {

            get("/") {
                call.respondText("Server is working")
            }

            authRoutes()
        }

    }.start(wait = true)
}