package es.mapper

import es.dto.UsuarioCreateDTO
import es.model.Usuario

fun UsuarioCreateDTO.toModel() = Usuario(
    username = TODO(),
    password = TODO(),
    nombre = TODO(),
    apellidos = TODO(),
    email = TODO(),
    userRole = TODO(),
    riotId = TODO(),
    createdAt = TODO(),
    updatedAt = TODO(),
    isActive = TODO()
)