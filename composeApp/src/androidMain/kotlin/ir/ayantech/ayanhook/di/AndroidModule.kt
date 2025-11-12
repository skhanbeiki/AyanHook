package ir.ayantech.ayanhook.di

import ir.ayantech.ayanhook.data.AndroidPreferenceDataStore
import ir.ayantech.ayanhook.utils.dataStore.PreferenceStorage
import org.koin.dsl.module

val androidModule = module {
     single<PreferenceStorage> { AndroidPreferenceDataStore( get()) }
}