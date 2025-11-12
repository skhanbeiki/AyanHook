package ir.ayantech.ayanhook

import android.app.Application
import ir.ayantech.ayanhook.di.androidModule
import ir.ayantech.ayanhook.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class AppController : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppController)
            modules(appModule, androidModule)
        }
    }
}