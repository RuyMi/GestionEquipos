package es.route

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.ucasoft.ktor.simpleCache.cacheOutput
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds
import io.ktor.server.auth.*
import io.ktor.server.http.content.*

fun Application.configureRouting() {
    routing {
        staticResources("/", "static", index = "index.html")
        cacheOutput(2.seconds) {
            get("/short") {
                call.respond(Random.nextInt().toString())
            }
        }
        cacheOutput {
            get("/default") {
                call.respond(Random.nextInt().toString())
            }
        }
        authenticate("myauth1") {
            get("/protected/route/basic") {
                val principal = call.principal<UserIdPrincipal>()!!
                call.respondText("Hello ${principal.name}")
            }
        }
        get("/json/kotlinx-serialization") {
            call.respond(mapOf("hello" to "world"))
        }
    }
    userRoute()
}
