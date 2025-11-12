package ir.ayantech.ayanhook

import androidx.compose.ui.window.ComposeUIViewController
import org.koin.core.context.startKoin
import platform.UIKit.UIViewController
import ir.ayantech.ayanhook.di.appModule
import ir.ayantech.ayanhook.di.iosModule
fun MainViewController(): UIViewController {
    startKoin {
        modules(appModule, iosModule)
    }
    return ComposeUIViewController { App() }
}