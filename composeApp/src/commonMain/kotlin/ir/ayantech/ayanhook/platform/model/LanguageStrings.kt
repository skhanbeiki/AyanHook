package ir.ayantech.ayanhook.platform.model

import ir.ayantech.ayanhook.presentation.ui.util.AppLanguage
import ir.ayantech.ayanhook.presentation.ui.util.LanguageManager
import kotlinx.serialization.Serializable

@Serializable
data class LanguageStrings(
    val fa: String = "",
    val en: String = ""
){
    val current: String
        get() = if (LanguageManager.currentLanguage == AppLanguage.FA) fa else en
}

