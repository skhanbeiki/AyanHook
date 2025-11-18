package ir.ayantech.ayanhook.presentation.login

import cafe.adriel.voyager.core.model.screenModelScope
import ir.ayantech.ayanhook.presentation.login.LoginState
import ir.ayantech.ayanhook.presentation.base.BaseViewModel
import ir.ayantech.ayanhook.data.remote.models.SendOtpParameters
import ir.ayantech.ayanhook.data.repository.LoginRepository
import ir.ayantech.ayanhook.presentation.login.LoginIntent
import ir.ayantech.ayanhook.data.local.prefs.PreferenceDataStoreHelper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: LoginRepository,
    private val prefHelper: PreferenceDataStoreHelper
) : BaseViewModel() {


    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state

    fun onIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.SendUsername -> sendUsername(intent.parameters)
            is LoginIntent.SendOtp -> sendOtp(intent.parameters)
            is LoginIntent.SaveIsLogin -> saveIsLogin(intent.key, intent.session)
            LoginIntent.ClearError -> clearError()
        }
    }

    private fun sendUsername(parameters: SendOtpParameters) {
        screenModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val result = repository.loginService(parameters)
                _state.update { it.copy(sendUsernameResponse = result) }
            } catch (e: Exception) {
                _state.update { it.copy(error = e.message) }
            } finally {
                _state.update { it.copy(isLoading = false) }
            }
        }
    }

    private fun sendOtp(parameters: SendOtpParameters) {
        screenModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val result = repository.loginService(parameters)
                _state.update { it.copy(sendOtpResponse = result) }
            } catch (e: Exception) {
                _state.update { it.copy(error = e.message) }
            } finally {
                _state.update { it.copy(isLoading = false) }
            }
        }
    }

    private fun saveIsLogin(key: String, session: Boolean) {
        screenModelScope.launch {
            prefHelper.saveBoolean(key, session)
        }
    }

//    private fun clearError() {
//        _state.update { it.copy(error = null) }
//    }
}