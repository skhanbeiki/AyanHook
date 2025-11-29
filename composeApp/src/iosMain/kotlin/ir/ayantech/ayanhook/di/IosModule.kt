package ir.ayantech.ayanhook.di

import ir.ayantech.ayanhook.data.local.preferences.IOSPreferenceDataStore
import ir.ayantech.ayanhook.data.local.preferences.PreferenceStorage
import org.koin.dsl.module

val iosModule = module {
    single<PreferenceStorage> { IOSPreferenceDataStore() }
}