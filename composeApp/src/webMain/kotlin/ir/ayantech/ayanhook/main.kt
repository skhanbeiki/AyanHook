package ir.ayantech.ayanhook

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import ir.ayantech.ayanhook.di.appModule
import org.koin.core.context.startKoin
import kotlin.js.JsModule

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
//    startKoin {
//        modules(appModule)
//    }
    ComposeViewport {
        App()
    }
}
