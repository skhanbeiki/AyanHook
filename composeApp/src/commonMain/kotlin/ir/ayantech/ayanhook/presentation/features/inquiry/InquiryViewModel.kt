package ir.ayantech.ayanhook.presentation.features.inquiry


import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import ir.ayantech.ayanhook.domain.usecase.auth.LoginUseCase
import ir.ayantech.ayanhook.platform.ConfigProject
import ir.ayantech.ayanhook.presentation.features.login.LoginEffect
import ir.ayantech.ayanhook.presentation.features.login.LoginIntent
import ir.ayantech.ayanhook.presentation.features.login.LoginState

class InquiryViewModel(
    private val configProject: ConfigProject,
    private val loginUseCase: LoginUseCase,
    private val ioDispatcher: CoroutineDispatcher
) {
    private val scope = CoroutineScope(SupervisorJob() + ioDispatcher)

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<LoginEffect>(extraBufferCapacity = 4)
    val effect: SharedFlow<LoginEffect> = _effect.asSharedFlow()

    fun process(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.EnterUsername -> _state.update { it.copy(username = intent.username) }
            is LoginIntent.EnterPassword -> _state.update { it.copy(password = intent.password) }
            is LoginIntent.Submit -> submit()
        }
    }

    private fun submit() {
        val username = state.value.username
        val password = state.value.password
        if (username.isBlank() || password.isBlank()) {
            scope.launch { _effect.emit(LoginEffect.ShowToast("Username and password cannot be empty")) }
            return
        }

        scope.launch {
            _state.update { it.copy(loading = true, userMessage = null) }
            try {
                val user = loginUseCase(username, password)
                _state.update { it.copy(loading = false, userMessage = "Welcome ${user.username}") }
                _effect.emit(LoginEffect.ShowToast("Login success"))
                _effect.emit(LoginEffect.Navigate("home"))
            } catch (e: Throwable) {
                _state.update { it.copy(loading = false) }
                _effect.emit(LoginEffect.ShowToast("Login failed: ${e.message ?: "unknown"}"))
            }
        }
    }
}
