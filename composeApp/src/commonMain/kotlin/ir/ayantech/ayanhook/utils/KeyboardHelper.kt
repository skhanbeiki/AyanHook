package ir.ayantech.ayanhook.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController

@Composable
fun rememberKeyboardManager(): KeyboardManager {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    return KeyboardManager(
        hideKeyboard = {
            focusManager.clearFocus()
            keyboardController?.hide()
        }
    )
}

class KeyboardManager(
    val hideKeyboard: () -> Unit
)