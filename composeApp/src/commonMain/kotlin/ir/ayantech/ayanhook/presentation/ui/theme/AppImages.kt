package ir.ayantech.ayanhook.presentation.ui.theme

import ayanhook.composeapp.generated.resources.Res
import ayanhook.composeapp.generated.resources.ic_gas_logo
import ayanhook.composeapp.generated.resources.ic_water_logo
import org.jetbrains.compose.resources.DrawableResource

object AppImages {

    var logo: DrawableResource = Res.drawable.ic_water_logo
    var background: DrawableResource = Res.drawable.ic_water_logo

    fun logo(name: String) {
        when (name) {
            "ic_water_logo" -> {
                logo =Res.drawable.ic_water_logo
            }
            "ic_gas_logo" -> {
                logo =Res.drawable.ic_gas_logo
            }
        }
    }

    fun background(name: String) {
        when (name) {
            "ic_water_logo" -> {
                background =Res.drawable.ic_water_logo
            }

            "ic_gas_logo" -> {
                background =Res.drawable.ic_gas_logo
            }
        }
    }
}