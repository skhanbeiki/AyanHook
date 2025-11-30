package ir.ayantech.ayanhook.data.repository

import ir.ayantech.ayanhook.data.mapper.auth.toDomain
import ir.ayantech.ayanhook.data.remote.auth.AuthApi
import ir.ayantech.ayanhook.domain.model.User
import ir.ayantech.ayanhook.domain.repository.AuthRepository
import ir.ayantech.ayanhook.data.dto.auth.LoginRequestDto

class AuthRepositoryImpl(private val api: AuthApi) : AuthRepository {
    override suspend fun login(username: String, password: String): User {
        val dto = LoginRequestDto(username, password)
        val res = api.login(dto)
        return res.toDomain()
    }
}//-> remote / local