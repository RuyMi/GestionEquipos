package es.dto

import kotlinx.serialization.Serializable

@Serializable
data class UsuarioCreateDTO(
    val username: String,
    val password: String,
    val nombre: String,
    val apellidos: String,
    val email: String,
    val riotId: String?
)