package ir.ayantech.ayanhook.di

import ir.ayantech.ayanhook.data.IOSPreferenceDataStore
import ir.ayantech.ayanhook.data.local.prefs.PreferenceStorage
import org.koin.dsl.module

val iosModule = module {
    single<PreferenceStorage> { IOSPreferenceDataStore() }
}