package ir.ayantech.ayanhook.di

import ir.ayantech.ayanhook.data.datasource.local.preferences.PreferenceStorage
import ir.ayantech.ayanhook.data.datasource.local.preferences.WasmPreferenceDataStore
import org.koin.dsl.module

val wasmModule = module {
    single<PreferenceStorage> { WasmPreferenceDataStore() }
}