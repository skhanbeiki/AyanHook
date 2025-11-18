package ir.ayantech.ayanhook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import org.jetbrains.compose.ui.tooling.preview.Preview

import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import ir.ayantech.ayanhook.presentation.main.MainScreen
import ir.ayantech.ayanhook.presentation.themes.AppTheme
import ir.ayantech.ayanhook.utils.AppLanguage
import ir.ayantech.ayanhook.utils.LanguageManager
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    val appViewModel = koinViewModel<AppViewModel>()
    val language by appViewModel.language.collectAsState(initial = null)
    if (language == null) return

    LaunchedEffect(language) {
        LanguageManager.currentLanguage = language ?: AppLanguage.FA
    }
    val isRtl = LanguageManager.currentLanguage == AppLanguage.FA
    val layoutDirection = if (isRtl) LayoutDirection.Rtl else LayoutDirection.Ltr

    CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
        AppTheme {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
            ) { innerPadding ->
                Navigator(MainScreen()) { navigator ->
                    SlideTransition(navigator)
                }
            }
        }
    }
}