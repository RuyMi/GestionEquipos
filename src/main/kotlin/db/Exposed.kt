package es.db

import io.ktor.server.application.*
import org.jetbrains.exposed.v1.jdbc.Database

fun Application.initDatabase(): Database {
    return Database.connect(
        url = environment.config.property("db.url").getString(),
        driver = environment.config.property("db.driver").getString(),
        user = environment.config.property("db.user").getString(),
        password = environment.config.property("db.password").getString(),
    )
}
