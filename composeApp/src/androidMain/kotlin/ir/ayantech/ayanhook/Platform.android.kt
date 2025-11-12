package ir.ayantech.ayanhook

class AndroidPlatform : Platform {
    override var platform: PlatformType = PlatformType.Android
    override var name: String = ""

    override var applicationNameForPishkhan: String = ""
    override var host: String = ""
    override var schema: String = ""
    override var applicationName: String = ""

    override var baseUrl: String = ""
    override var servicesBaseUrl: String = ""
    override var versionControllingBaseUrl: String = ""
    override var pushNotificationUrl: String = ""

    val cafebazaar = "Cafebazaar"
    val myket = "Myket"
    val playstore = "Playstore"

    init {
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
                servicesBaseUrl = "https://services.pishkhan24.ayantech.ir/webservices/services.svc/"
                versionControllingBaseUrl = "https://versioncontrol.infra.ayantech.ir/WebServices/App.svc/"
                pushNotificationUrl = "https://pushnotification.infra.ayantech.ir/WebServices/App.svc/"
            }
            BuildConfig.FLAVOR.contains(playstore, ignoreCase = true) -> {
                baseUrl = "https://corepishkhan24.ayanco.ae/WebServices/Core.svc/"
                servicesBaseUrl = "https://corepishkhan24.ayanco.ae/WebServices/services.svc/"
                versionControllingBaseUrl = "https://versioncontrolinfra.ayanco.ae/WebServices/App.svc/"
                pushNotificationUrl = "https://pushnotificationinfra.ayanco.ae/WebServices/App.svc/"
            }
        }
    }
}

actual fun getPlatform(): Platform = AndroidPlatform()