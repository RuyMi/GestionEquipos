package es.repository

import at.favre.lib.crypto.bcrypt.BCrypt
import es.enum.Rol
import es.model.Usuario
import io.ktor.server.config.yaml.*
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.transactions.transaction
import java.sql.Connection


class UserRepository(
    private val db: Database,
    private val crypt: BCrypt.HashData
): ICRUDRepository {

    private val config = YamlConfig("application.yaml")
    private val salt = config?.propertyOrNull("security.salt")!!.getString().toInt()
    private var errNum = 0
    private var errTxt = ""

    override fun create(usuario: Usuario){
        val hashedPassword = BCrypt.withDefaults().hashToString(salt, usuario.password.toCharArray())
        transaction(db) {
            val conex = connection.connection as Connection
            conex.prepareCall("{call pCrearUsuario(?,?,?,?,?,?,?,?,?,?,?)}").use { param ->
                param.setString("Username", usuario.username)
                param.setString("Password", hashedPassword)
                param.setString("Nombre", usuario.nombre)
                param.setString("Apellidos", usuario.apellidos)
                param.setString("Email", usuario.email)
                param.setString("Rol", usuario.userRole.name)
                param.setString("CreatedAt", usuario.createdAt)
                param.setString("UpdatedAt", usuario.updatedAt)
                param.setString("isActive", usuario.isActive.toString())
                param.registerOutParameter("ErrTxt", java.sql.Types.VARCHAR)
                param.registerOutParameter("ErrNum", java.sql.Types.INTEGER)
                param.execute()

                errNum = param.getInt("ErrNum")
                errTxt = param.getString("ErrTxt")
            }
            if (errNum != 0) {
                throw Exception("Codigo: $errNum - Mensaje: $errTxt")
            }
        }

    }

    override fun delete(username: String) {
        transaction(db) {
            val conex = connection.connection as Connection
            conex.prepareCall("{call pBorrarUsuario(?,?,?)}").use { param ->
                param.setString("Username", username)
                param.registerOutParameter("ErrTxt", java.sql.Types.VARCHAR)
                param.registerOutParameter("ErrNum", java.sql.Types.INTEGER)
                param.execute()

                errNum = param.getInt("ErrNum")
                errTxt = param.getString("ErrTxt")
            }
            if (errNum != 0) {
                throw Exception("Codigo: $errNum - Mensaje: $errTxt")
            }
        }
    }

    override fun finByUUID(uuid: String): Usuario? {
        return transaction(db) {
            val conex = connection.connection as Connection

            conex.prepareCall("{call pBuscarUsuarioPorUUID(?,?,?)}").use { param ->
                param.setString("UUID", uuid)
                param.registerOutParameter("ErrTxt", java.sql.Types.VARCHAR)
                param.registerOutParameter("ErrNum", java.sql.Types.INTEGER)

                val usuario = param.executeQuery().use { rs ->
                    if (rs.next()) {
                        Usuario(
                            username = rs.getString("username"),
                            password = rs.getString("password"),
                            nombre = rs.getString("nombre"),
                            apellidos = rs.getString("apellidos"),
                            email = rs.getString("email"),
                            userRole = Rol.valueOf(rs.getString("rol")),
                            riotId = rs.getString("riotId"),
                            createdAt = rs.getString("createdAt"),
                            updatedAt = rs.getString("updatedAt"),
                            isActive = rs.getBoolean("isActive")
                        )
                    } else {
                        null
                    }
                }
                errNum = param.getInt("ErrNum")
                errTxt = param.getString("ErrTxt") ?: ""

                if (errNum != 0) {
                    throw Exception("Codigo: $errNum - Mensaje: $errTxt")
                }
                usuario
            }
        }
    }

    override fun finByUsername(username: String) {
        return transaction(db) {
            val conex = connection.connection as Connection

            conex.prepareCall("{call pBuscarUsuarioPorUsername(?,?,?)}").use { param ->
                param.setString("Username", username)
                param.registerOutParameter("ErrTxt", java.sql.Types.VARCHAR)
                param.registerOutParameter("ErrNum", java.sql.Types.INTEGER)

                val usuario = param.executeQuery().use { rs ->
                    if (rs.next()) {
                        Usuario(
                            username = rs.getString("username"),
                            password = rs.getString("password"),
                            nombre = rs.getString("nombre"),
                            apellidos = rs.getString("apellidos"),
                            email = rs.getString("email"),
                            userRole = Rol.valueOf(rs.getString("rol")),
                            riotId = rs.getString("riotId"),
                            createdAt = rs.getString("createdAt"),
                            updatedAt = rs.getString("updatedAt"),
                            isActive = rs.getBoolean("isActive")
                        )
                    } else {
                        null
                    }
                }
                errNum = param.getInt("ErrNum")
                errTxt = param.getString("ErrTxt") ?: ""

                if (errNum != 0) {
                    throw Exception("Codigo: $errNum - Mensaje: $errTxt")
                }
                usuario
            }
        }
    }
}