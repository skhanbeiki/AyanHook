package ir.ayantech.ayanhook.di

import ir.ayantech.ayanhook.AppViewModel
import ir.ayantech.ayanhook.data.ApiService
import ir.ayantech.ayanhook.data.ApiServiceImpl
import ir.ayantech.ayanhook.data.createHttpClient
import ir.ayantech.ayanhook.utils.dataStore.PreferenceDataStoreHelper
import ir.ayantech.ayanhook.utils.dataStore.PreferenceStorage
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule: Module = module {
    single { createHttpClient() }
    single<ApiService> { ApiServiceImpl(get(), get()) }

    single { PreferenceDataStoreHelper(get()) }

    viewModel { AppViewModel(get()) }
}