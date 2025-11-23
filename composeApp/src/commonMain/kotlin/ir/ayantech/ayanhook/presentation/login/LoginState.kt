package ir.ayantech.ayanhook.presentation.login

import ir.ayantech.ayanhook.data.remote.models.SendOtpResponseParameters
import ir.ayantech.ayanhook.data.remote.models.baseModels.BaseResponse

data class LoginState(
    val sendUsernameResponse: BaseResponse<SendOtpResponseParameters>? = null,
    val sendOtpResponse: BaseResponse<SendOtpResponseParameters>? = null
)