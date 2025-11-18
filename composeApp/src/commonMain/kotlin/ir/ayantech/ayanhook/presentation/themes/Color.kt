package ir.ayantech.ayanhook.presentation.themes

import androidx.compose.ui.graphics.Color
import ir.ayantech.ayanhook.PlatformHolder

object AppColors {
    private val projectName = PlatformHolder.name.lowercase()

    val White = Color.White
    val Black = Color.Black
    val Transparent = Color(0xFFFFFFFF)
    var Primary = Color(0xFF2196F3)
    var Background = Color(0xFFE3F2FD)
    var TextPrimary = Color(0xFF0D47A1)
    var Grey_3 = Color(0xFF616161)
    var Grey_1 = Color(0xFF9A090B)

    init {
        when (projectName) {
            "waterbillinquiry" -> {
                Primary = Color(0xFF2196F3)
                Background = Color(0xFFE3F2FD)
                TextPrimary = Color(0xFF0D47A1)
            }

            "gasbillinquiry" -> {
                Primary = Color(0xFFFF5722)
                Background = Color(0xFFFFE0B2)
                TextPrimary = Color(0xFFBF360C)
            }
        }
    }
}