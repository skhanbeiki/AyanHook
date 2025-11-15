package ir.ayantech.ayanhook.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun AdBannerContainer(
    containerKey: String,
    modifier: Modifier = Modifier
)
