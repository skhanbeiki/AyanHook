package ir.ayantech.ayanhook.presentation.features.login

sealed class LoginEffect {
    data class ShowToast(val message: String): LoginEffect()
    data class Navigate(val destination: String): LoginEffect()
}