package ir.ayantech.ayanhook.di

import org.koin.core.context.GlobalContext.startKoin

actual fun initKoin(appContext: Any?) {
     startKoin {
        modules(appModule, jsModule)
    }
}