package ir.ayantech.ayanhook.di

import ir.ayantech.ayanhook.data.JsPreferenceDataStore
import ir.ayantech.ayanhook.utils.dataStore.PreferenceStorage
import org.koin.dsl.module

val jsModule = module {
    single<PreferenceStorage> { JsPreferenceDataStore() }
}