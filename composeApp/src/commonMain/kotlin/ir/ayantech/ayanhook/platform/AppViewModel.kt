package ir.ayantech.ayanhook.platform

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.ayantech.ayanhook.data.datasource.local.preferences.PreferenceDataStoreHelper
import ir.ayantech.ayanhook.data.datasource.local.preferences.PreferencesKeys
import ir.ayantech.ayanhook.presentation.ui.util.AppLanguage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AppViewModel(
    private val configProject: ConfigProject,
    private val prefHelper: PreferenceDataStoreHelper
) : ViewModel() {

    private val _language = MutableStateFlow<AppLanguage?>(null)
    val language: StateFlow<AppLanguage?> = _language

    init {
        viewModelScope.launch {
             configProject.getConfigProject()

            val savedLang = prefHelper.readString(PreferencesKeys.APP_LANGUAGE)
            _language.value = when (savedLang) {
                "FA" -> AppLanguage.FA
                "EN" -> AppLanguage.EN
                else -> AppLanguage.FA
            }
        }
    }
}