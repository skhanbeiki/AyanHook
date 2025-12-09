package ir.ayantech.ayanhook.presentation.ui.theme

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import ayanhook.composeapp.generated.resources.Res
import ayanhook.composeapp.generated.resources.ic_gas_logo
import ayanhook.composeapp.generated.resources.ic_water_logo

object AppImages {

    @OptIn(ExperimentalResourceApi::class)
    val logo
        @Composable get() = when ("projectName") {
            "waterbillinquiry" -> painterResource(Res.drawable.ic_water_logo)
            "gasbillinquiry" -> painterResource(Res.drawable.ic_gas_logo)
            else -> painterResource(Res.drawable.ic_water_logo)
        }

    @OptIn(ExperimentalResourceApi::class)
    val background
        @Composable get() = when ("projectName") {
            "waterbillinquiry" -> painterResource(Res.drawable.ic_water_logo)
            "gasbillinquiry" -> painterResource(Res.drawable.ic_gas_logo)
            else -> painterResource(Res.drawable.ic_water_logo)
        }
}