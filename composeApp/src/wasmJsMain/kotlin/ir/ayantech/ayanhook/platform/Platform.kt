package ir.ayantech.ayanhook.platform

import ir.ayantech.ayanhook.platform.model.PlatformDate
import ir.ayantech.ayanhook.platform.model.PlatformType

fun wasmPlatform(): PlatformDate {
    val platform: PlatformType = PlatformType.Web
    var name = ""

    var applicationNameForPishkhan = ""
    var host = ""
    var schema = ""
    var applicationName= ""

    var baseUrl = ""
    var servicesBaseUrl = ""
    var versionControllingBaseUrl = ""
    var pushNotificationUrl = ""

    return PlatformDate(
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

actual fun getPlatform() = wasmPlatform()