package ir.ayantech.ayanhook.platform

import ir.ayantech.ayanhook.BuildConfig
import ir.ayantech.ayanhook.platform.model.PlatformData
import ir.ayantech.ayanhook.platform.model.PlatformType

fun androidPlatform(): PlatformData {
    val platform: PlatformType = PlatformType.Android
    var name = ""

    var applicationNameForPishkhan = ""
    var host = ""
    var schema = ""
    var applicationName= ""

    var baseUrl = ""
    var servicesBaseUrl = ""
    var versionControllingBaseUrl = ""
    var pushNotificationUrl = ""

    val cafebazaar = "Cafebazaar"
    val myket = "Myket"
    val playstore = "Playstore"

    when {
        BuildConfig.FLAVOR.contains("waterbillinquiry", ignoreCase = true)
                && (BuildConfig.FLAVOR.contains(cafebazaar, ignoreCase = true)
                || BuildConfig.FLAVOR.contains(myket, ignoreCase = true))
            -> {
            name = "waterbillinquiry"
            applicationNameForPishkhan = "PishkhanWaterBillInquiry"
            host = "ir.ayantech.waterbillinquiry"
            schema = "waterbillinquiry"
            applicationName = "VasHookWaterBillInquiry"
        }

        BuildConfig.FLAVOR.contains("waterbillinquiry", ignoreCase = true)
                && (BuildConfig.FLAVOR.contains(playstore, ignoreCase = true))
            -> {
            name = "waterbillinquiry"
            applicationNameForPishkhan = "aewaterbillinquiry"
            host = "ae.ayanco.aewaterbillinquiry"
            schema = "aewaterbillinquiry"
            applicationName = "aewaterbillinquiry"
        }

        BuildConfig.FLAVOR.contains("gasbillinquiry", ignoreCase = true)
                && (BuildConfig.FLAVOR.contains(cafebazaar, ignoreCase = true)
                || BuildConfig.FLAVOR.contains(myket, ignoreCase = true))
            -> {
            name = "gasbillinquiry"
            applicationNameForPishkhan = "PishkhanGasBillInquiry"
            host = "ir.ayantech.gasbillinquiry"
            schema = "gasbillinquiry"
            applicationName = "VasHookGasBillInquiry"
        }

        BuildConfig.FLAVOR.contains("gasbillinquiry", ignoreCase = true)
                && (BuildConfig.FLAVOR.contains(playstore, ignoreCase = true))
            -> {
            name = "gasbillinquiry"
            applicationNameForPishkhan = "aegasbillinquiry"
            host = "ae.ayanco.gasbillinquiry"
            schema = "gasbillinquiry"
            applicationName = "aegasbillinquiry"
        }
    }

    when {
        BuildConfig.FLAVOR.contains(cafebazaar, ignoreCase = true)
                || BuildConfig.FLAVOR.contains(myket, ignoreCase = true) -> {
            baseUrl = "https://core.pishkhan24.ayantech.ir/webservices/Core.svc/"
            servicesBaseUrl =
                "https://services.pishkhan24.ayantech.ir/webservices/services.svc/"
            versionControllingBaseUrl =
                "https://versioncontrol.infra.ayantech.ir/WebServices/App.svc/"
            pushNotificationUrl =
                "https://pushnotification.infra.ayantech.ir/WebServices/App.svc/"
        }

        BuildConfig.FLAVOR.contains(playstore, ignoreCase = true) -> {
            baseUrl = "https://corepishkhan24.ayanco.ae/WebServices/Core.svc/"
            servicesBaseUrl = "https://corepishkhan24.ayanco.ae/WebServices/services.svc/"
            versionControllingBaseUrl =
                "https://versioncontrolinfra.ayanco.ae/WebServices/App.svc/"
            pushNotificationUrl = "https://pushnotificationinfra.ayanco.ae/WebServices/App.svc/"
        }
    }

    return PlatformData(
        platform = platform,
        name = name,
        applicationNameForPishkhan = applicationNameForPishkhan,
        host = host,
        schema = schema,
        applicationName = applicationName,
        baseUrl = baseUrl,
        servicesBaseUrl = servicesBaseUrl,
        versionControllingBaseUrl = versionControllingBaseUrl,
        pushNotificationUrl = pushNotificationUrl,
    )
}

actual fun getPlatform() = androidPlatform()