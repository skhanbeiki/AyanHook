package ir.ayantech.ayanhook

interface Platform {
    val platform: PlatformType
    val name: String
    val applicationNameForPishkhan: String
    val host: String
    val schema: String
    val applicationName: String
    val baseUrl: String
    val servicesBaseUrl: String
    val versionControllingBaseUrl: String
    val pushNotificationUrl: String
}

expect fun getPlatform(): Platform

private val platformInstance: Platform by lazy { getPlatform() }

object PlatformHolder {
    val platform: Platform get() = platformInstance
    val name: String get() = platformInstance.name
}

enum class PlatformType { Android, Desktop, Web, IOS, Unknown }
