package ir.ayantech.ayanhook.di

import ir.ayantech.ayanhook.data.datasource.local.preferences.PreferenceDataStoreHelper
import ir.ayantech.ayanhook.data.datasource.local.preferences.PreferenceStorage
import ir.ayantech.ayanhook.data.datasource.remote.auth.AuthApi
import ir.ayantech.ayanhook.data.datasource.remote.auth.KtorAuthApi
import ir.ayantech.ayanhook.data.repository.AuthRepositoryImpl
import ir.ayantech.ayanhook.domain.repository.AuthRepository
import ir.ayantech.ayanhook.domain.usecase.auth.LoginUseCase
import ir.ayantech.ayanhook.presentation.features.login.LoginViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val appModule = module {

    single { PreferenceDataStoreHelper(get()) }
    single<PreferenceStorage> { get() }
    single { KtorAuthApi(get()) as AuthApi }
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
    factory { LoginUseCase(get()) }
    factory { LoginViewModel(get(), Dispatchers.Default) }
}