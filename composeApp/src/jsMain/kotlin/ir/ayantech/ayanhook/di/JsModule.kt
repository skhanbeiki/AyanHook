package ir.ayantech.ayanhook.di

import ir.ayantech.ayanhook.data.JsPreferenceDataStore
import ir.ayantech.ayanhook.data.local.prefs.PreferenceStorage
import org.koin.dsl.module

val jsModule = module {
    single<PreferenceStorage> { JsPreferenceDataStore() }
}