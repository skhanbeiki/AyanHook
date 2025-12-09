package ir.ayantech.ayanhook.presentation.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import ir.ayantech.ayanhook.presentation.ui.theme.AppColors
import ir.ayantech.ayanhook.presentation.ui.theme.AppStrings
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun InputFieldPreview() {
    var inputText by rememberSaveable { mutableStateOf("") }
    var isValid by rememberSaveable { mutableStateOf(false) }

    InputField(
        inputText = inputText,
        isValid = isValid,
        onInputTextChange = { inputText = it },
        onValidChange = { isValid = it }
    )
}

@Composable
fun InputField(
    inputText: String,
    isValid: Boolean,
    onInputTextChange: (String) -> Unit,
    onValidChange: (Boolean) -> Unit
) {

    BasicTextField(
        value = inputText,
        onValueChange = { input ->
            val trimmed = input.take(10)

            onInputTextChange(trimmed)
            onValidChange(trimmed.length >= 10)
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .border(
                width = 1.dp,
                color = AppColors.black,
                shape = RoundedCornerShape(12.dp)
            ),
        textStyle = TextStyle(
            color = AppColors.black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        ),
        decorationBox = { innerTextField ->
            if (inputText.isEmpty()) {
                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = AppStrings.nationalCode.fa,
                    color = AppColors.grey_3,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center
                )
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                innerTextField()
            }
        }
    )
}
