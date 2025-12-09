package ir.ayantech.ayanhook.platform.model

import kotlinx.serialization.Serializable

@Serializable
data class ConfigData(
    val platform: PlatformDate = PlatformDate(),
    val colors: PlatformColor = PlatformColor(),
    val strings: PlatformStrings = PlatformStrings(),
    val images: PlatformImage = PlatformImage(),
    val info: PlatformInfo = PlatformInfo()
)