package ir.ayantech.ayanhook.data

import io.ktor.client.HttpClient
import ir.ayantech.ayanhook.utils.dataStore.PreferenceDataStoreHelper

interface ApiService {
}

class ApiServiceImpl(
    private val client: HttpClient,
    private val prefHelper: PreferenceDataStoreHelper
) : ApiService {
    val baseUrl = "https://core.pishkhan24.ayantech.ir/webservices/core.svc/"
    val servicesBaseUrl = "https://services.pishkhan24.ayantech.ir/webservices/services.svc/"
}

expect fun createHttpClient(): HttpClient