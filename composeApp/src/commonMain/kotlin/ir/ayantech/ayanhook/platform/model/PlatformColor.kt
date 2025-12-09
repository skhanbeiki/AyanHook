package ir.ayantech.ayanhook.platform.model

import androidx.compose.ui.graphics.Color
import ir.ayantech.ayanhook.presentation.ui.util.ColorHexSerializer
import kotlinx.serialization.Serializable

@Serializable
data class PlatformColor(
    @Serializable(with = ColorHexSerializer::class)
    val primary: Color = Color(0xFF2196F3),

    @Serializable(with = ColorHexSerializer::class)
    val background: Color = Color(0xFFE3F2FD),

    @Serializable(with = ColorHexSerializer::class)
    val textPrimary: Color = Color(0xFF0D47A1),
)
