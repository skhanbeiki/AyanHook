package ir.ayantech.ayanhook.data.remote.models.baseModels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Status(
    @SerialName("Code")
    val code: String,

    @SerialName("Description")
    val description: String,

    @SerialName("IsFromCache")
    val isFromCache: Boolean,

    @SerialName("Retryable")
    val retryable: Boolean,

    @SerialName("Type")
    val type: String
)
