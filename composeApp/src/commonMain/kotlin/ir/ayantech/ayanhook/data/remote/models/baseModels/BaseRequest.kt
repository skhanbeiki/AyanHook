package ir.ayantech.ayanhook.data.remote.models.baseModels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseRequest<T>(

    @SerialName("Identity")
    val identity: Identity? = null,

    @SerialName("Parameters")
    val parameters: T? = null
)
