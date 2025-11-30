package ir.ayantech.ayanhook.di

import ir.ayantech.ayanhook.data.datasource.local.preferences.JsPreferenceDataStore
import ir.ayantech.ayanhook.data.datasource.local.preferences.PreferenceStorage
import org.koin.dsl.module

val jsModule = module {
    single<PreferenceStorage> { JsPreferenceDataStore( ) }

}