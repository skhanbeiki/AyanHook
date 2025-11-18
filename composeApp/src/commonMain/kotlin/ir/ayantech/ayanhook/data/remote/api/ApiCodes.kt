package ir.ayantech.ayanhook.data.remote.api

import ir.ayantech.ayanhook.data.remote.models.baseModels.Status

object ApiCodes {
    const val SUCCESS = "G00000"
}

fun Status.isSuccess(): Boolean = code == ApiCodes.SUCCESS