package ir.ayantech.ayanhook.data.remote.models.baseModels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    @SerialName("Parameters")
    val parameters: T? = null,

    @SerialName("Status")
    val status: Status? = null,
)
