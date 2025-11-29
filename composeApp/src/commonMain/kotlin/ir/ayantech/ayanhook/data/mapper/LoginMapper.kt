package ir.ayantech.ayanhook.data.mapper

import ir.ayantech.ayanhook.data.dto.LoginResponseDto
import ir.ayantech.ayanhook.domain.model.User

fun LoginResponseDto.toDomain(): User = User(id = userId, username = userName)