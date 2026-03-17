package org.example.routes

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import org.example.database.MongoFactory
import org.example.model.User
import kotlinx.coroutines.flow.firstOrNull
import org.bson.Document

@Serializable
data class LoginRequest(
    val username: String,
    val password: String
)

fun Route.authRoutes() {

    post("/login") {

        val request = call.receive<LoginRequest>()

        val collection =
            MongoFactory.database.getCollection<User>("users")

        val user = collection
            .find(Document("username", request.username))
            .firstOrNull()

        if (user != null && user.password == request.password) {
            call.respond(
                mapOf(
                    "success" to true,
                    "user" to user
                )
            )
        } else {
            call.respond(mapOf("success" to false))
        }
    }
}