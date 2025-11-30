package ir.ayantech.ayanhook.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.serialization.json.Json
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {

    var json by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        json = loadJsonFile("water")
        val config = Json.decodeFromString<ProjectConfig>(json)

    }
}