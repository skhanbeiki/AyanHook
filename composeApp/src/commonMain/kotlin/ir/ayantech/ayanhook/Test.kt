package ir.ayantech.ayanhook

import ayanhook.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
suspend fun loadJsonFile(name: String): String {
    val bytes = Res.readBytes("files/test.json")
    return bytes.decodeToString()
}