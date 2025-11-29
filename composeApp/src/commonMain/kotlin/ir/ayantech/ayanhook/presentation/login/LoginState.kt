package ir.ayantech.ayanhook.presentation.login

data class LoginState(
    val username: String = "",
    val password: String = "",
    val loading: Boolean = false,
    val userMessage: String? = null
)