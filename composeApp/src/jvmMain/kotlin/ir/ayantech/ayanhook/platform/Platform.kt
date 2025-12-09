package ir.ayantech.ayanhook.platform

import ir.ayantech.ayanhook.platform.model.PlatformData
import ir.ayantech.ayanhook.platform.model.PlatformType

fun jvmPlatform(): PlatformData {
    val platform: PlatformType = PlatformType.Desktop
    var name = ""

    var applicationNameForPishkhan = ""
    var host = ""
    var schema = ""
    var applicationName= ""

    var baseUrl = ""
    var servicesBaseUrl = ""
    var versionControllingBaseUrl = ""
    var pushNotificationUrl = ""

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

actual fun getPlatform() = jvmPlatform()