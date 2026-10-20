package es.route

import es.dto.UsuarioCreateDTO
import io.ktor.server.application.*
import io.ktor.server.request.receive
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

fun Application.userRoute() {
    routing {
        post("/user") {
            val usuario = call.receive<UsuarioCreateDTO>()

        }
    }
}

