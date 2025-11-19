package ir.ayantech.ayanhook.di

import ir.ayantech.ayanhook.AppViewModel
import ir.ayantech.ayanhook.data.ApiService
import ir.ayantech.ayanhook.data.ApiServiceImpl
import ir.ayantech.ayanhook.data.createHttpClient
import ir.ayantech.ayanhook.data.repository.LoginRepository
import ir.ayantech.ayanhook.data.repository.LoginRepositoryImpl
import ir.ayantech.ayanhook.presentation.login.LoginViewModel
import ir.ayantech.ayanhook.data.local.prefs.PreferenceDataStoreHelper
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule: Module = module {
    single { createHttpClient() }
    single<ApiService> { ApiServiceImpl(get(), get()) }

    single { PreferenceDataStoreHelper(get()) }

    single<LoginRepository> { LoginRepositoryImpl(get()) }
    factory { LoginViewModel(get(), get()) }

    viewModel { AppViewModel(get()) }
}