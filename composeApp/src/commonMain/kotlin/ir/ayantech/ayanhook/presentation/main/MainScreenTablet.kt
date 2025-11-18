package ir.ayantech.ayanhook.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.ayantech.ayanhook.presentation.themes.AppColors
import ir.ayantech.ayanhook.presentation.themes.AppImages
import ir.ayantech.ayanhook.presentation.themes.AppStrings
import org.jetbrains.compose.ui.tooling.preview.Preview


@Preview(name = "Tablet Layout", widthDp = 800, heightDp = 1280)
@Composable
fun MainScreenTablet() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppColors.Primary,
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            // کارت مرکزی
            Column(
                modifier = Modifier
                    .width(500.dp)
                    .fillMaxHeight()
                    .background(
                        color = AppColors.Background,
                        shape = RoundedCornerShape(32.dp)
                    )
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Header
                Image(
                    painter = AppImages.logo,
                    contentDescription = "Logo",
                    modifier = Modifier.size(96.dp)
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = AppStrings.TITLE,
                    color = AppColors.Primary,
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = AppStrings.DESCRIPTION,
                    color = AppColors.TextPrimary,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(32.dp))

                var nationalCode by rememberSaveable { mutableStateOf("") }
                var isValid by remember { mutableStateOf(false) }

                BasicTextField(
                    value = nationalCode,
                    onValueChange = {
                        nationalCode = it.take(10)
                        isValid = it.length >= 10
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .border(
                            width = 1.dp,
                            color = AppColors.Black,
                            shape = RoundedCornerShape(16.dp)
                        ),
                    textStyle = TextStyle(
                        color = AppColors.Black,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    ),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            if (nationalCode.isEmpty()) {
                                Text(
                                    text = AppStrings.NATIONAL_CODE,
                                    color = AppColors.Grey_3,
                                    fontSize = 16.sp,
                                )
                            }
                            innerTextField()
                        }
                    }
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {},
                    enabled = isValid,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppColors.Primary,
                        disabledContainerColor = AppColors.Grey_1
                    )
                ) {
                    Text(
                        text = AppStrings.Inquiry,
                        fontSize = 18.sp,
                        color = if (isValid) AppColors.White else AppColors.Black
                    )
                }
            }
        }
    }
}