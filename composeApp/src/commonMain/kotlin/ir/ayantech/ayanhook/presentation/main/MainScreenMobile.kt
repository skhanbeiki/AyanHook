package ir.ayantech.ayanhook.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.ayantech.ayanhook.presentation.themes.AppColors
import ir.ayantech.ayanhook.presentation.themes.AppImages
import ir.ayantech.ayanhook.presentation.themes.AppStrings
import ir.ayantech.ayanhook.utils.AdBannerContainer
import org.jetbrains.compose.ui.tooling.preview.Preview


@Preview(name = "Mobile Layout", widthDp = 390, heightDp = 844)
@Composable
fun MainScreenMobile() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppColors.Primary,
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
                    painter = AppImages.logo,
                    contentDescription = "Logo",
                    modifier = Modifier.size(72.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = AppStrings.TITLE,
                    color = AppColors.White,
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = AppStrings.DESCRIPTION,
                    color = AppColors.White,
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
                        color = AppColors.Background,
                        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                    )
                    .padding(horizontal = 16.dp)
            ) {

                AdBannerContainer(
                    containerKey = "ccb7504c-b986-4448-ab8b-2059e0e78f5a",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = AppStrings.STRING_1,
                    color = AppColors.Black,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp,
                )
                Spacer(modifier = Modifier.height(16.dp))

                var nationalCode by rememberSaveable { mutableStateOf("") }
                var isValid by remember { mutableStateOf(false) }

                BasicTextField(
                    value = nationalCode,
                    onValueChange = { it->
                        println("Error confirmed -> $it")
                        nationalCode = it.take(10)
                        isValid = it.length >= 10
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .border(
                            width = 1.dp,
                            color = AppColors.Black,
                            shape = RoundedCornerShape(12.dp)
                        ),
                    textStyle = TextStyle(
                        color = AppColors.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center
                    ),
                    decorationBox = { innerTextField ->
                        if (nationalCode.isEmpty()) {
                            Text(
                                modifier = Modifier.wrapContentSize(),
                                text = AppStrings.NATIONAL_CODE,
                                color = AppColors.Grey_3,
                                fontSize = 14.sp,
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Center
                            )
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            innerTextField()
                        }
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                    },
                    enabled = isValid,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppColors.Primary,
                        contentColor = AppColors.White,
                        disabledContainerColor = AppColors.Grey_1
                    )
                ) {
                    Text(
                        text = AppStrings.Inquiry,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        color = if (isValid) AppColors.Black else AppColors.White
                    )
                }
            }
        }
    }
}