package ir.ayantech.ayanhook.di

import ir.ayantech.ayanhook.data.WasmPreferenceDataStore
import ir.ayantech.ayanhook.utils.dataStore.PreferenceStorage
import org.koin.dsl.module

val wasmModule = module {
    single<PreferenceStorage> { WasmPreferenceDataStore() }
}