package ir.ayantech.ayanhook.platform.model

import kotlinx.serialization.Serializable

@Serializable
data class PlatformStrings(
    val title: LanguageStrings = LanguageStrings("استعلام قبض آب", "Water Bill Inquiry"),
    val description: LanguageStrings = LanguageStrings("مشاهده و پرداخت قبض آب شما","View and pay your water bill")
)

