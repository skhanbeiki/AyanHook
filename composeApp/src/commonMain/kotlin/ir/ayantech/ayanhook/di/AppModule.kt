package ir.ayantech.ayanhook.di

import org.koin.dsl.module
import ir.ayantech.ayanhook.data.remote.impl.KtorAuthApi
import ir.ayantech.ayanhook.data.repository.AuthRepositoryImpl
import ir.ayantech.ayanhook.domain.usecase.LoginUseCase
import ir.ayantech.ayanhook.domain.repository.AuthRepository
import ir.ayantech.ayanhook.presentation.login.LoginViewModel
import kotlinx.coroutines.Dispatchers
import ir.ayantech.ayanhook.data.remote.AuthApi

val appModule = module {

    single { KtorAuthApi(get(), baseUrl = "https://example.com") as AuthApi }
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    factory { LoginUseCase(get()) }
    factory { LoginViewModel(get(), Dispatchers.Default) }
}