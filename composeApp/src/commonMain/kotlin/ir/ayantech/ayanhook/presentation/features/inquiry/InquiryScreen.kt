package ir.ayantech.ayanhook.presentation.features.inquiry

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import ir.ayantech.ayanhook.presentation.ui.components.InputField
import ir.ayantech.ayanhook.presentation.ui.components.PrimaryButton
import ir.ayantech.ayanhook.presentation.ui.theme.AppColors
import ir.ayantech.ayanhook.presentation.ui.theme.AppImages
import ir.ayantech.ayanhook.presentation.ui.theme.AppStrings
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

class InquiryScreen() : Screen {

    @Composable
    override fun Content() {
        val viewModel = koinScreenModel<InquiryViewModel>()
        val uiState by viewModel.state.collectAsState()

        ContentPreview()
    }

    @Composable
    @Preview
    fun ContentPreview() {
        println("ogvqihqjegnow  ContentPreview")
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = AppColors.primary,
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.3f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(AppImages.logo),
                        contentDescription = "Logo",
                        modifier = Modifier.size(72.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = AppStrings.title.current,
                        color = AppColors.white,
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = AppStrings.description.current,
                        color = AppColors.white,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp,
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.7f)
                        .background(
                            color = AppColors.background,
                            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                        )
                        .padding(horizontal = 16.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = AppStrings.string1.current,
                        color = AppColors.black,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    var inputText by rememberSaveable { mutableStateOf("") }
                    var isValid by rememberSaveable { mutableStateOf(false) }

                    InputField(
                        inputText = inputText,
                        isValid = isValid,
                        onInputTextChange = { inputText = it },
                        onValidChange = { isValid = it }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    PrimaryButton(
                        onClick = {},
                    )
                }
            }
        }

    }
}