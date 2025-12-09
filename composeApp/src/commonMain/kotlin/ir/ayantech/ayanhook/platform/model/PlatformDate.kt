package ir.ayantech.ayanhook.platform.model


import kotlinx.serialization.Serializable

@Serializable
data class PlatformDate(
    val platform: PlatformType = PlatformType.Android,
    val marketName: MarketName = MarketName.Cafebazaar,
    val name: String = "",
    val applicationNameForPishkhan: String = "",
    val host: String = "",
    val schema: String = "",
    val applicationName: String = "",
    val baseUrl: String = "",
    val servicesBaseUrl: String = "",
    val versionControllingBaseUrl: String = "",
    val pushNotificationUrl: String = ""
)