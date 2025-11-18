package ir.ayantech.ayanhook.presentation.main

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import org.jetbrains.compose.ui.tooling.preview.Preview

class MainScreen() : Screen {

    @Composable
    override fun Content() {
        ContentPreview()
    }

    @Composable
    @Preview
    fun ContentPreview() {
        BoxWithConstraints {
            if (maxWidth < 600.dp) {
                MainScreenMobile()
            } else if (maxWidth < 900.dp) {
                MainScreenTablet()
            } else {
                MainScreenWeb()
            }
        }
    }
}
