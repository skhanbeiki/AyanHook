package ir.ayantech.ayanhook

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import ir.ayantech.ayanhook.di.initKoin
fun MainViewController(): UIViewController {
    initKoin()
    return ComposeUIViewController { App() }
}