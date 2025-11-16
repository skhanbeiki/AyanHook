package ir.ayantech.ayanhook.di

import org.koin.core.context.startKoin

actual fun initKoin(appContext: Any?) {
    startKoin {
        modules(appModule, iosModule)
    }
}