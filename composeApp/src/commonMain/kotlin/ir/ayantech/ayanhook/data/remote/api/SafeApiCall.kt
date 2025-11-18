package ir.ayantech.ayanhook.data.remote.api

import ir.ayantech.ayanhook.data.remote.models.baseModels.BaseResponse

suspend fun <T> safeApiCall(
    apiCall: suspend () -> BaseResponse<T>
): BaseResponse<T> {
    return try {
        val response = apiCall()
        if (response.status?.isSuccess() == true) {
            response
        } else {
            throw ApiException(response.status?.description)
        }
    } catch (e: Exception) {
        println("Error confirmed " + e.message)
        throw ApiException(e.message ?: "Unknown error")
    }
}

class ApiException(message: String?) : Exception(message)
