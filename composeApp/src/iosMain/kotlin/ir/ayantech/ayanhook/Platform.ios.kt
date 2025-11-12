package ir.ayantech.ayanhook

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val platform: PlatformType = PlatformType.IOS
    override val name: String = "waterbillinquiry"
    override val applicationNameForPishkhan: String = ""
    override val host: String = ""
    override val schema: String = ""
    override val applicationName: String = ""
    override val baseUrl: String = ""
    override val servicesBaseUrl: String = ""
    override val versionControllingBaseUrl: String = ""
    override val pushNotificationUrl: String = ""
}

actual fun getPlatform(): Platform = IOSPlatform()