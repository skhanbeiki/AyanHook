package ir.ayantech.ayanhook.di

import ir.ayantech.ayanhook.data.local.preferences.JvmPreferenceDataStore
import ir.ayantech.ayanhook.data.local.preferences.PreferenceStorage
import org.koin.dsl.module

val JvmModule = module {
    single<PreferenceStorage> { JvmPreferenceDataStore() }
}