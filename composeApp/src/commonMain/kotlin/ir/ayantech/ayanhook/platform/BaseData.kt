package ir.ayantech.ayanhook.platform

import ir.ayantech.ayanhook.platform.model.MarketName
import ir.ayantech.ayanhook.platform.model.PlatformType

object BaseData {
    var platform: PlatformType = PlatformType.Android
    var marketName: MarketName = MarketName.Cafebazaar
    var name: String = ""
    var applicationNameForPishkhan: String = ""
    var host: String = ""
    var schema: String = ""
    var applicationName: String = ""
    var baseUrl: String = ""
    var servicesBaseUrl: String = ""
    var versionControllingBaseUrl: String = ""
    var pushNotificationUrl: String = ""
}