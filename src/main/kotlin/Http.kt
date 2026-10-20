package es

import io.ktor.server.application.*
import io.ktor.http.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.response.*
import com.ucasoft.ktor.simpleCache.SimpleCache
import com.ucasoft.ktor.simpleMemoryCache.*
import kotlin.time.Duration.Companion.seconds
import io.ktor.server.plugins.compression.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.routing.*

fun Application.configureHttp() {
    install(CORS) {
        allowMethod(HttpMethod.Options)
        allowMethod(HttpMethod.Get)
        allowMethod(HttpMethod.Put)
        allowMethod(HttpMethod.Delete)
        allowMethod(HttpMethod.Patch)
        allowHeader(HttpHeaders.Authorization)
        allowHeader("MyCustomHeader")
        anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
    }
    install(SimpleCache) {
        memoryCache {
            invalidateAt = 10.seconds
        }
    }
    install(Compression)
    routing {
        swaggerUI(path = "openapi") {
            /*
             Documentation source configuration goes here.
    
             This can be from file (documentation.yaml), or it can be served dynamically from your sources using the
             `describe {}` API on routes.  When `openApi` enabled in Gradle, these calls will be automatically injected
             based on your code and comments.
             */
        }
    }
}
