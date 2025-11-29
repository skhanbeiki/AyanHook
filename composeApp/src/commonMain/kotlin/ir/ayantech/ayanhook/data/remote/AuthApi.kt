package ir.ayantech.ayanhook.data.remote

import ir.ayantech.ayanhook.data.dto.LoginRequestDto
import ir.ayantech.ayanhook.data.dto.LoginResponseDto

interface AuthApi {
    suspend fun login(request: LoginRequestDto): LoginResponseDto
}