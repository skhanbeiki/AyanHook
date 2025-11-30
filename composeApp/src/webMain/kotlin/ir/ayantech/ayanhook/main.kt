package ir.ayantech.ayanhook

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import ir.ayantech.ayanhook.di.initKoin
import ir.ayantech.ayanhook.platform.App

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin()
    ComposeViewport {
        App()
    }
}
