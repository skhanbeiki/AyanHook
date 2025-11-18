package ir.ayantech.ayanhook.data.remote.models.baseModels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Identity(

    @SerialName("Token")
    val token: String
)
