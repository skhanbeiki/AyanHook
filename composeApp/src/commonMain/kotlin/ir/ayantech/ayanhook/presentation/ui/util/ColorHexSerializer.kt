package ir.ayantech.ayanhook.presentation.ui.util

import androidx.compose.ui.graphics.Color
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

object ColorHexSerializer : KSerializer<Color> {

    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("ColorHex", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Color {
        val hex = decoder.decodeString().removePrefix("0x")
        val longValue = hex.toLong(16)
        return Color(longValue)
    }

    override fun serialize(encoder: Encoder, value: Color) {
        val hex = value.value.toString(16).uppercase()
        encoder.encodeString("0x$hex")
    }
}