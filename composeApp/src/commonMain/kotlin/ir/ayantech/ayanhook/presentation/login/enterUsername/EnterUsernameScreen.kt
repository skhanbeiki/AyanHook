package ir.ayantech.ayanhook.presentation.login.enterUsername

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import ir.ayantech.ayanhook.data.remote.models.SendOtpParameters
import ir.ayantech.ayanhook.presentation.login.LoginIntent
import ir.ayantech.ayanhook.presentation.login.LoginViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

class EnterUsernameScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel = koinScreenModel<LoginViewModel>()
        val uiState by viewModel.state.collectAsState()

        LaunchedEffect(Unit) {
            viewModel.onIntent(LoginIntent.SendUsername(SendOtpParameters("09119009338")))
        }

        if (uiState.isLoading) {

        }

        uiState.error?.let {
//            ErrorView(it) {
//                viewModel.onIntent(LoginIntent.ClearError)
//            }
        }

        uiState.sendUsernameResponse?.let {

        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun EnterUsernameContent(
        onSendClick: (String) -> Unit,
    ) {

    }
}