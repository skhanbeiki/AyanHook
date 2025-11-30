package ir.ayantech.ayanhook.di

import ir.ayantech.ayanhook.data.datasource.local.preferences.IOSPreferenceStorage
import org.koin.dsl.module

val iosModule = module {
    single<IOSPreferenceStorage> { IOSPreferenceStorage() }
}