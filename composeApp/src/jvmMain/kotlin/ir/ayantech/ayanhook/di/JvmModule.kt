package ir.ayantech.ayanhook.di

import ir.ayantech.ayanhook.data.JvmPreferenceDataStore
import ir.ayantech.ayanhook.data.local.prefs.PreferenceStorage
import org.koin.dsl.module

val JvmModule = module {
    single<PreferenceStorage> { JvmPreferenceDataStore() }
}