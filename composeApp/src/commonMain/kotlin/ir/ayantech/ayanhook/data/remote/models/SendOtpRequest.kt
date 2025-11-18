package ir.ayantech.ayanhook.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SendOtpParameters(
    @SerialName("OTPCode")
    val otpCode: String? = null,

    @SerialName("Username")
    val username: String? = null
)