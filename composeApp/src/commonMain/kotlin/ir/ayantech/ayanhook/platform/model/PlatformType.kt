package ir.ayantech.ayanhook.platform.model

import kotlinx.serialization.Serializable

@Serializable
enum class PlatformType {
    Android, Desktop, Web, IOS, Unknown
}