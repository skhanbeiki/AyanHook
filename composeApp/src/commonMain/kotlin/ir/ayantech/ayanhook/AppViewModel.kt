package ir.ayantech.ayanhook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.ayantech.ayanhook.utils.AppLanguage
import ir.ayantech.ayanhook.utils.dataStore.PreferenceDataStoreHelper
import ir.ayantech.ayanhook.utils.dataStore.PreferencesKeys
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AppViewModel(private val prefHelper: PreferenceDataStoreHelper) : ViewModel() {
    private val _language = MutableStateFlow<AppLanguage?>(null)
    val language: StateFlow<AppLanguage?> = _language

    init {
        viewModelScope.launch {
            val savedLang = prefHelper.readString(PreferencesKeys.APP_LANGUAGE)
            _language.value = when (savedLang) {
                "FA" -> AppLanguage.FA
                "EN" -> AppLanguage.EN
                else -> AppLanguage.FA
            }
        }
    }
}