package es.repository

import es.model.Usuario

interface ICRUDRepository {
    fun create(usuario: Usuario)
    fun delete(username: String)
    fun finByUUID(uuid: String): Usuario?
    fun finByUsername(username: String)
}