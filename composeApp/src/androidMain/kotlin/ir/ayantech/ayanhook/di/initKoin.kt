package ir.ayantech.ayanhook.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

actual fun initKoin(appContext: Any?) {
    startKoin {
        androidContext(appContext as Context)
        modules(appModule, androidModule)
    }
}