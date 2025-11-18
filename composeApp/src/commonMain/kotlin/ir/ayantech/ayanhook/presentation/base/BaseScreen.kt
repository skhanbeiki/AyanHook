package ir.ayantech.ayanhook.presentation.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import ir.ayantech.ayanhook.utils.KeyboardManager
import ir.ayantech.ayanhook.utils.rememberKeyboardManager
import ayanhook.composeapp.generated.resources.Res
import ayanhook.composeapp.generated.resources.bold
import ayanhook.composeapp.generated.resources.medium
import ayanhook.composeapp.generated.resources.regular
import org.jetbrains.compose.resources.Font

@Composable
fun BaseScreen(
    viewModel: BaseViewModel? = null,
    onErrorConfirmed: (() -> Unit)? = null,
    content: @Composable (
        keyboard: KeyboardManager
    ) -> Unit
) {
    val keyboard = rememberKeyboardManager()
    val error by viewModel?.error?.collectAsState() ?: remember { mutableStateOf(null) }
    val isGlobalLoading by viewModel?.isLoading?.collectAsState()
        ?: remember { mutableStateOf(false) }

    val fontFamily = FontFamily(
        Font(Res.font.bold, weight = FontWeight.Bold),
        Font(Res.font.medium, weight = FontWeight.Medium),
        Font(Res.font.regular, weight = FontWeight.Normal)
    )

    var showErrorSheet by remember { mutableStateOf(false) }
    var showLoadingSheet by remember { mutableStateOf(false) }

    LaunchedEffect(error, isGlobalLoading) {
        if (error != null) {
            showErrorSheet = true
        }
        if (isGlobalLoading) {
            showLoadingSheet = true
        }
    }
    content(keyboard)

    if (showErrorSheet && error != null) {
//        ErrorBottomSheet(
//            error,
//            onClick = {
//                viewModel?.clearError()
//                onErrorConfirmed?.invoke()
//            },
//            onDismiss = {
//                showErrorSheet = false
//                viewModel?.clearError()
//            }, fontFamily
//        )
    }
    if (showLoadingSheet && isGlobalLoading) {
//        WaiterBottomSheet(
//            onClick = {
//
//            },
//            onDismiss = {
//                showLoadingSheet = false
//            }, fontFamily
//        )
    }
}