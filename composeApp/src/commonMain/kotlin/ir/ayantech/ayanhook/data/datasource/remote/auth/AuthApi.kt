package ir.ayantech.ayanhook.data.datasource.remote.auth

import ir.ayantech.ayanhook.data.dto.auth.LoginRequestDto
import ir.ayantech.ayanhook.data.dto.auth.LoginResponseDto

interface AuthApi {
    suspend fun login(request: LoginRequestDto): LoginResponseDto
}