package ir.ayantech.ayanhook.di

import ir.ayantech.ayanhook.data.local.preferences.WasmPreferenceDataStore
import ir.ayantech.ayanhook.data.local.preferences.PreferenceStorage
import org.koin.dsl.module

val wasmModule = module {
    single<PreferenceStorage> { WasmPreferenceDataStore() }
}