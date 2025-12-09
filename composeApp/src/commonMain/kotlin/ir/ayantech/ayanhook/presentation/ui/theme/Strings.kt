package ir.ayantech.ayanhook.presentation.ui.theme

import ir.ayantech.ayanhook.platform.model.LanguageStrings
import ir.ayantech.ayanhook.presentation.ui.util.AppLanguage
import ir.ayantech.ayanhook.presentation.ui.util.LanguageManager

object AppStrings {
    private val lang: AppLanguage
        get() = LanguageManager.currentLanguage

    var title: LanguageStrings = LanguageStrings("استعلام قبض آب", "Water Bill Inquiry")
    var description: LanguageStrings = LanguageStrings("مشاهده و پرداخت قبض آب شما","View and pay your water bill")

    val rial: LanguageStrings = LanguageStrings(" ریال"," Rial")
    val string1: LanguageStrings = LanguageStrings("برای استعلام، کد ملی خود را وارد کنید","Enter your National ID to inquiry justice shares")
    val nationalCode: LanguageStrings = LanguageStrings("کد ملی","National ID")
    val inquiry: LanguageStrings = LanguageStrings("استعلام","Inquiry")

}