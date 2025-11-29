package ir.ayantech.ayanhook.data.dto


import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseDto(
    val userId: String,
    val userName: String
)