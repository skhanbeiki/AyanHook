package ir.ayantech.ayanhook.themes

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import ayanhook.composeapp.generated.resources.Res
import ayanhook.composeapp.generated.resources.ic_gas_logo
import ayanhook.composeapp.generated.resources.ic_water_logo
import ir.ayantech.ayanhook.PlatformHolder

object AppImages {
    private val projectName = PlatformHolder.name.lowercase()

    @OptIn(ExperimentalResourceApi::class)
    val logo
        @Composable get() = when (projectName) {
            "waterbillinquiry" -> painterResource(Res.drawable.ic_water_logo)
            "gasbillinquiry" -> painterResource(Res.drawable.ic_gas_logo)
            else -> painterResource(Res.drawable.ic_water_logo)
        }

    @OptIn(ExperimentalResourceApi::class)
    val background
        @Composable get() = when (projectName) {
            "waterbillinquiry" -> painterResource(Res.drawable.ic_water_logo)
            "gasbillinquiry" -> painterResource(Res.drawable.ic_gas_logo)
            else -> painterResource(Res.drawable.ic_water_logo)
        }
}