package ir.ayantech.ayanhook.presentation.ui.theme

import ir.ayantech.ayanhook.platform.PlatformHolder
import ir.ayantech.ayanhook.presentation.ui.util.AppLanguage
import ir.ayantech.ayanhook.presentation.ui.util.LanguageManager

object AppStrings {
    private val projectName = PlatformHolder.name.lowercase()
    private val lang: AppLanguage
        get() = LanguageManager.currentLanguage

    val TITLE: String
        get() = when (projectName) {
            "waterbillinquiry" -> when (lang) {
                AppLanguage.FA -> "استعلام قبض آب"
                AppLanguage.EN -> "Water Bill Inquiry"
            }
            "gasbillinquiry" -> when (lang) {
                AppLanguage.FA -> "استعلام قبض گاز"
                AppLanguage.EN -> "Gas Bill Inquiry"
            }
            else -> when (lang) {
                AppLanguage.FA -> "استعلام"
                AppLanguage.EN -> "Inquiry"
            }
        }

    val DESCRIPTION: String
        get() = when (projectName) {
            "waterbillinquiry" -> when (lang) {
                AppLanguage.FA -> "مشاهده و پرداخت قبض آب شما"
                AppLanguage.EN -> "View and pay your water bill"
            }
            "gasbillinquiry" -> when (lang) {
                AppLanguage.FA -> "مشاهده و پرداخت قبض گاز شما"
                AppLanguage.EN -> "View and pay your gas bill"
            }
            else -> when (lang) {
                AppLanguage.FA -> "مشاهده و پرداخت قبض"
                AppLanguage.EN -> "View and pay your bill"
            }
        }


    val RIAL: String
        get() = when (lang) {
            AppLanguage.FA -> " ریال"
            AppLanguage.EN -> " Rial"
        }

    val STRING_1: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.FA -> "برای استعلام، کد ملی خود را وارد کنید"
            AppLanguage.EN -> "Enter your National ID to inquiry justice shares"
        }
    val NATIONAL_CODE: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.FA -> "کد ملی"
            AppLanguage.EN -> "National ID"
        }
    val Inquiry: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.FA -> "استعلام"
            AppLanguage.EN -> "Inquiry Justice Shares"
        }
}