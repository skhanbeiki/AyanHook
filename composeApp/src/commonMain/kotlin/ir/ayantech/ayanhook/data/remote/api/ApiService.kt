package ir.ayantech.ayanhook.data.remote.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import ir.ayantech.ayanhook.data.remote.models.SendOtpParameters
import ir.ayantech.ayanhook.data.remote.models.SendOtpResponseParameters
import ir.ayantech.ayanhook.data.remote.models.baseModels.BaseRequest
import ir.ayantech.ayanhook.data.remote.models.baseModels.BaseResponse
import ir.ayantech.ayanhook.data.remote.models.baseModels.Identity
import ir.ayantech.ayanhook.data.local.prefs.PreferenceDataStoreHelper
import ir.ayantech.ayanhook.data.local.prefs.PreferencesKeys

interface ApiService {
    suspend fun loginService(parameters: SendOtpParameters): BaseResponse<SendOtpResponseParameters>
}

class ApiServiceImpl(
    private val client: HttpClient,
    private val prefHelper: PreferenceDataStoreHelper
) : ApiService {
    val baseUrl = "https://core.pishkhan24.ayantech.ir/webservices/core.svc/"
    val servicesBaseUrl = "https://services.pishkhan24.ayantech.ir/webservices/services.svc/"

    override suspend fun loginService(parameters: SendOtpParameters): BaseResponse<SendOtpResponseParameters> {
        val session = prefHelper.readString(PreferencesKeys.SESSION_TOKEN)
        if (session == null) {
            throw IllegalStateException("Session token is missing")
        }

        val requestBody = BaseRequest(
            identity = Identity(token = session),
            parameters = parameters
        )

        return client.post("${baseUrl}v1/LoginByOTP") {
            contentType(ContentType.Application.Json)
            setBody(requestBody)
        }.body()
    }

}

expect fun createHttpClient(): HttpClient