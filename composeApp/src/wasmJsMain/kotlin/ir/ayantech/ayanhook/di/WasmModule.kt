package ir.ayantech.ayanhook.di

import ir.ayantech.ayanhook.data.WasmPreferenceDataStore
import ir.ayantech.ayanhook.data.local.prefs.PreferenceStorage
import org.koin.dsl.module

val wasmModule = module {
    single<PreferenceStorage> { WasmPreferenceDataStore() }
}