package dev.rsandtner.sandbox.cmp.tasky.core.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import tasky.composeapp.generated.resources.Res
import tasky.composeapp.generated.resources.eye_icon
import tasky.composeapp.generated.resources.eye_off_icon
import tasky.composeapp.generated.resources.hide_password
import tasky.composeapp.generated.resources.show_password

@Composable
fun TaskyPasswordField(
    state: TextFieldState,
    isPasswordVisible: Boolean,
    onToggleVisibility: () -> Unit,
    placeholder: String? = null,
    isError: Boolean = false,
    modifier: Modifier = Modifier.Companion,
) {
    TaskyTextFieldBase(
        modifier = modifier,
        isError = isError,
    ) { style, interactionSource, taskyPlaceholder ->

        BasicSecureTextField(
            state = state,
            modifier = style,
            interactionSource = interactionSource,
            textStyle = MaterialTheme.typography.bodyMedium,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            textObfuscationMode = if (isPasswordVisible) TextObfuscationMode.Visible else TextObfuscationMode.Hidden,
            decorator = { content ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        taskyPlaceholder(placeholder, state)
                        content()
                    }
                    Icon(
                        imageVector = if (isPasswordVisible) vectorResource(Res.drawable.eye_icon) else vectorResource(Res.drawable.eye_off_icon),
                        contentDescription = if (isPasswordVisible) stringResource(Res.string.hide_password) else stringResource(Res.string.show_password),
                        modifier = Modifier
                            .size(24.dp)
                            .clickable(
                                interactionSource = interactionSource,
                                indication = ripple(
                                    bounded = false,
                                    radius = 24.dp
                                ),
                                onClick = onToggleVisibility
                            )
                    )
                }
            },
        )
    }
}

@Composable
@Preview
private fun TaskySecretTextFieldLightNormalPreview(
) {
    MaterialTheme {
        TaskyPasswordField(
            state = TextFieldState(""),
            isPasswordVisible = false,
            onToggleVisibility = { },
            placeholder = "Placeholder"
        )
    }
}

@Composable
@Preview
private fun TaskySecretTextFieldLightFilledPreview(
) {
    MaterialTheme {
        TaskyPasswordField(
            state = TextFieldState("secret"),
            isPasswordVisible = false,
            onToggleVisibility = { },
            placeholder = "Placeholder"
        )
    }
}

@Composable
@Preview
private fun TaskySecretTextFieldLightErrorPreview(
) {
    MaterialTheme {
        TaskyPasswordField(
            state = TextFieldState("secret"),
            isPasswordVisible = false,
            onToggleVisibility = { },
            placeholder = "Placeholder",
            isError = true
        )
    }
}

@Composable
@Preview
private fun TaskySecretTextFieldLightRevealedPreview(
) {
    MaterialTheme {
        TaskyPasswordField(
            state = TextFieldState("secret"),
            isPasswordVisible = true,
            onToggleVisibility = { },
            placeholder = "Placeholder"
        )
    }
}

@Composable
@Preview
private fun TaskySecretTextFieldDarkNormalPreview(
) {

    MaterialTheme(colorScheme = darkColorScheme()) {
        TaskyPasswordField(
            state = TextFieldState(""),
            isPasswordVisible = false,
            onToggleVisibility = { },
            placeholder = "Placeholder"
        )
    }
}

@Composable
@Preview
private fun TaskySecretTextFieldDarkFilledPreview(
) {
    MaterialTheme(colorScheme = darkColorScheme()) {
        TaskyPasswordField(
            state = TextFieldState("secret"),
            isPasswordVisible = false,
            onToggleVisibility = { },
            placeholder = "Placeholder"
        )
    }
}

@Composable
@Preview
private fun TaskySecretTextFieldDarkErrorPreview(
) {
    MaterialTheme(colorScheme = darkColorScheme()) {
        TaskyPasswordField(
            state = TextFieldState("secret"),
            isPasswordVisible = false,
            onToggleVisibility = { },
            placeholder = "Placeholder",
            isError = true
        )
    }
}

@Composable
@Preview
private fun TaskySecretTextFieldDarkRevealedPreview(
) {
    MaterialTheme(colorScheme = darkColorScheme()) {
        TaskyPasswordField(
            state = TextFieldState("secret"),
            isPasswordVisible = true,
            onToggleVisibility = { },
            placeholder = "Placeholder"
        )
    }
}
