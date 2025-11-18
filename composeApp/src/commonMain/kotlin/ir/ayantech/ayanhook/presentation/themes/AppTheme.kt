package ir.ayantech.ayanhook.presentation.themes

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import ayanhook.composeapp.generated.resources.Res
import ayanhook.composeapp.generated.resources.bold
import ayanhook.composeapp.generated.resources.medium
import ayanhook.composeapp.generated.resources.regular
import org.jetbrains.compose.resources.Font


@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val fontFamily = FontFamily(
        Font(Res.font.bold, weight = FontWeight.Bold),
        Font(Res.font.medium, weight = FontWeight.Medium),
        Font(Res.font.regular, weight = FontWeight.Normal)
    )

    val typography = Typography(
        bodySmall = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal
        ),
        bodyMedium = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium
        ),
        bodyLarge = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold
        )
    )

    MaterialTheme(
        typography = typography,
        content = content
    )
}