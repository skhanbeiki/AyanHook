package ir.ayantech.ayanhook.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import ir.ayantech.ayanhook.presentation.ui.theme.AppColors
import ir.ayantech.ayanhook.presentation.ui.theme.AppStrings
import ir.ayantech.ayanhook.presentation.ui.theme.Dimens.ButtonHeight
import ir.ayantech.ayanhook.presentation.ui.theme.Dimens.RoundedCorner
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun PrimaryButtonPreview() {
    PrimaryButton(
        onClick = { },
    )
}

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
) {
    var isValid by rememberSaveable { mutableStateOf(false) }

    Button(
        onClick = {
            onClick()
        },
        enabled = isValid,
        modifier = Modifier
            .fillMaxWidth()
            .height(ButtonHeight),
        shape = RoundedCornerShape(RoundedCorner),
        colors = ButtonDefaults.buttonColors(
            containerColor = AppColors.primary,
            contentColor = AppColors.white,
            disabledContainerColor = AppColors.green
        )
    ) {
        Text(
            text = AppStrings.inquiry.current,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = if (isValid) AppColors.black else AppColors.white
        )
    }
}