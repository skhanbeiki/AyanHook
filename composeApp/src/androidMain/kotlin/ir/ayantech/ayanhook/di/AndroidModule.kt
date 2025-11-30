package ir.ayantech.ayanhook.di

import ir.ayantech.ayanhook.data.datasource.local.preferences.AndroidPreferenceStorage
import ir.ayantech.ayanhook.data.datasource.local.preferences.PreferenceStorage
import org.koin.dsl.module

val androidModule = module {
    single<PreferenceStorage> { AndroidPreferenceStorage(get()) }
}