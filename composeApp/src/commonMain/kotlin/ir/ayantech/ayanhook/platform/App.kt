package ir.ayantech.ayanhook.platform

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import ir.ayantech.ayanhook.presentation.features.inquiry.InquiryScreen
import ir.ayantech.ayanhook.presentation.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    AppTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
        ) { innerPadding ->
            Navigator(InquiryScreen()) { navigator ->
                SlideTransition(navigator)
            }
        }
    }
}