package es

import at.favre.lib.crypto.bcrypt.BCrypt
import es.db.initDatabase
import es.repository.ICRUDRepository
import es.repository.UserRepository
import io.ktor.server.application.*
import org.jetbrains.exposed.v1.jdbc.Database
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin() {
    val database = initDatabase()
    install(Koin) {
        slf4jLogger()
        modules(module {
            single<BCrypt.Hasher>{
                BCrypt.withDefaults()
            }
            single<Database> { database }
            single<ICRUDRepository> { UserRepository(get(), get()) }
        })
    }
}


