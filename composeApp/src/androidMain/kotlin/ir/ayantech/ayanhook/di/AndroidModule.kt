package ir.ayantech.ayanhook.di

import ir.ayantech.ayanhook.data.local.preferences.AndroidPreferenceDataStore
import ir.ayantech.ayanhook.data.local.preferences.PreferenceStorage
import org.koin.dsl.module

val androidModule = module {
     single<PreferenceStorage> { AndroidPreferenceDataStore( get()) }
}