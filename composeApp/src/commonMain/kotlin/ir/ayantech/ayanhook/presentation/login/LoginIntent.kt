package ir.ayantech.ayanhook.presentation.login

import ir.ayantech.ayanhook.data.remote.models.SendOtpParameters

sealed class LoginIntent {
    data class SendUsername(val parameters: SendOtpParameters) : LoginIntent()
    data class SendOtp(val parameters: SendOtpParameters) : LoginIntent()
    data class SaveIsLogin(val key: String, val session: Boolean) : LoginIntent()
}