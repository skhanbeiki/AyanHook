package ir.ayantech.ayanhook.di

import ir.ayantech.ayanhook.data.IOSPreferenceDataStore
import ir.ayantech.ayanhook.utils.dataStore.PreferenceStorage
import org.koin.dsl.module

val iosModule = module {
    single<PreferenceStorage> { IOSPreferenceDataStore() }
}