package ir.ayantech.ayanhook.platform

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import ir.ayantech.ayanhook.presentation.features.inquiry.InquiryScreen
import ir.ayantech.ayanhook.presentation.ui.theme.AppTheme
import ir.ayantech.ayanhook.presentation.ui.util.AppLanguage
import ir.ayantech.ayanhook.presentation.ui.util.LanguageManager
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel


@Composable
@Preview
fun App() {
    val appViewModel = koinViewModel<AppViewModel>()
    val language by appViewModel.language.collectAsState(initial = null)

    LanguageManager.currentLanguage = language ?: AppLanguage.FA

    if (language == null) return

    val isRtl = LanguageManager.currentLanguage == AppLanguage.FA
    val layoutDirection = if (isRtl) LayoutDirection.Rtl else LayoutDirection.Ltr

    CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
        AppTheme {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
            ) {
                Navigator(InquiryScreen()) { navigator ->
                    SlideTransition(navigator)
                }
            }
        }
    }
}