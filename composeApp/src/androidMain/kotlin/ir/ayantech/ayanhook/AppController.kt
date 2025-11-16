package ir.ayantech.ayanhook

import android.app.Application
import ir.ayantech.ayanhook.di.initKoin


class AppController : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(this@AppController)
    }
}