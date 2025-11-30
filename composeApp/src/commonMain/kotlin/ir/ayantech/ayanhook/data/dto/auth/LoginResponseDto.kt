package ir.ayantech.ayanhook.data.dto.auth


import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseDto(
    val userId: String,
    val userName: String
)