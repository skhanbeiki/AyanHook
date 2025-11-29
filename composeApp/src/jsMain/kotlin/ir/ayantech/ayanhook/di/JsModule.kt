package ir.ayantech.ayanhook.di

import ir.ayantech.ayanhook.data.local.preferences.JsPreferenceDataStore
import ir.ayantech.ayanhook.data.local.preferences.PreferenceStorage
import org.koin.dsl.module

val jsModule = module {
    single<PreferenceStorage> { JsPreferenceDataStore() }
}