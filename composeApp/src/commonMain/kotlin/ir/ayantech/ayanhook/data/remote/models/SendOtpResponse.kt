package ir.ayantech.ayanhook.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class SendOtpResponseParameters {
    @SerialName("OtpDetails")
    val otp: OtpDetails? = null
}

@Serializable
data class OtpDetails(
    @SerialName("Length")
    val length: Int,

    @SerialName("Message")
    val message: String? = null,

    @SerialName("ReferenceNumber")
    val referenceNumber: String? = null,

    @SerialName("Timer")
    val timer: Long,

    @SerialName("Validation")
    val validation: String
)