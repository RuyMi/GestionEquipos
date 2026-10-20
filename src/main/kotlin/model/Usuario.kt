package es.model

import es.enum.Rol

data class Usuario(
    val username: String,
    val password: String,
    val nombre: String,
    val apellidos: String,
    val email: String,
    val userRole: Rol = Rol.USER,
    val riotId: String? = "",
    val createdAt: String?,
    val updatedAt: String?,
    val isActive: Boolean = true
){
    override fun toString(): String {
        return "username $username\n password $password\n email $email\n nombre $nombre\n Rol $userRole\n Creado: $createdAt\n Actualizado: $updatedAt Activo: $isActive"
    }
}


