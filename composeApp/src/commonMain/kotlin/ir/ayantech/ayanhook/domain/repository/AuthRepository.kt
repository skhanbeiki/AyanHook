package ir.ayantech.ayanhook.domain.repository

import ir.ayantech.ayanhook.domain.model.User

interface AuthRepository {
    suspend fun login(username: String, password: String): User
}