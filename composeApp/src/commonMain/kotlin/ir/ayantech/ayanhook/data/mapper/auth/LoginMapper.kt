package ir.ayantech.ayanhook.data.mapper.auth

import ir.ayantech.ayanhook.data.dto.auth.LoginResponseDto
import ir.ayantech.ayanhook.domain.model.User

fun LoginResponseDto.toDomain(): User = User(id = userId, username = userName)