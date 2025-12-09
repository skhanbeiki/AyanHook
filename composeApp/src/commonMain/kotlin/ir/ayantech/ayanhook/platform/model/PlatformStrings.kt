package ir.ayantech.ayanhook.platform.model

import kotlinx.serialization.Serializable

@Serializable
data class PlatformStrings(
    val title: LanguageStrings = LanguageStrings("استعلام قبض آب", "Water Bill Inquiry"),
)

