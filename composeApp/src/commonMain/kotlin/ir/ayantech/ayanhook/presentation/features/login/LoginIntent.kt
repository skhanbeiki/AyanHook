package ir.ayantech.ayanhook.presentation.features.login

sealed class LoginIntent {
    data class EnterUsername(val username: String) : LoginIntent()
    data class EnterPassword(val password: String) : LoginIntent()
    object Submit : LoginIntent()
}