package ir.ayantech.ayanhook.platform

import ayanhook.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
suspend fun loadJsonFile(name: String): String {
    val bytes = Res.readBytes("files/water.json")
    return bytes.decodeToString()
}