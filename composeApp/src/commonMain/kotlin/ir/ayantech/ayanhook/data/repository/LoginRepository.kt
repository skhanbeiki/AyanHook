package ir.ayantech.ayanhook.data.repository

import ir.ayantech.ayanhook.data.remote.api.ApiService
import ir.ayantech.ayanhook.data.remote.models.baseModels.BaseResponse
import ir.ayantech.ayanhook.data.remote.models.SendOtpParameters
import ir.ayantech.ayanhook.data.remote.models.SendOtpResponseParameters
import ir.ayantech.ayanhook.data.remote.api.safeApiCall

interface LoginRepository {
    suspend fun loginService(parameters: SendOtpParameters): BaseResponse<SendOtpResponseParameters>
}

class LoginRepositoryImpl(
    private val apiService: ApiService
) : LoginRepository {
    override suspend fun loginService(parameters: SendOtpParameters): BaseResponse<SendOtpResponseParameters> {
        return safeApiCall { apiService.loginService(parameters) }
    }
}