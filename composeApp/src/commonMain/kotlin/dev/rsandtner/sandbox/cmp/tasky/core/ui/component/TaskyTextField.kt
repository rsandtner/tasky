package dev.rsandtner.sandbox.cmp.tasky.core.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

private val textFieldShape = RoundedCornerShape(10.dp)

@Composable
fun TaskyTextField(
    state: TextFieldState,
    placeholder: String? = null,
    isError: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    BasicTextField(
        state = state,
        modifier = style(modifier, isError, isFocused, MaterialTheme.colorScheme),
        interactionSource = interactionSource,
        textStyle = MaterialTheme.typography.bodyMedium,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        decorator = { content ->
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {
                Placeholder(
                    placeholder = placeholder,
                    state = state,
                    isFocused = isFocused
                )

                content()
            }
        },
    )
}

@Composable
fun TaskyPasswordField(
    state: TextFieldState,
    placeholder: String? = null,
    isError: Boolean = false,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    var isPasswordVisible by remember { mutableStateOf(false) }

    BasicSecureTextField(
        state = state,
        modifier = style(modifier, isError, isFocused, MaterialTheme.colorScheme),
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
                    Placeholder(
                        placeholder = placeholder,
                        state = state,
                        isFocused = isFocused
                    )
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
                            onClick = { isPasswordVisible = !isPasswordVisible }
                        )
                )
            }
        },
    )
}

@Composable
private fun Placeholder(placeholder: String?, state: TextFieldState, isFocused: Boolean) {
    if (state.text.isEmpty() && !placeholder.isNullOrEmpty()) {
        Text(
            text = placeholder,
            style = MaterialTheme.typography.bodyMedium,
            color = if (isFocused) MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = .7f) else MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}


private fun style(
    modifier: Modifier,
    isError: Boolean,
    isFocused: Boolean,
    colorScheme: ColorScheme
) = modifier
    .background(colorScheme.surfaceContainerHigh, textFieldShape)
    .border(
        width = 1.dp,
        color = when {
            isError -> colorScheme.error
            isFocused -> colorScheme.outline
            else -> Color.Transparent
        },
        shape = textFieldShape
    )
    .padding(horizontal = 20.dp, vertical = 12.dp)
    .heightIn(min = 24.dp) // without a min height, the textfield gets a little bit smaller when starting to type on macOS

@Composable
@Preview(showBackground = true)
fun TaskyTextFieldLightNormalPreview(
) {
    MaterialTheme {
        TaskyTextField(
            state = TextFieldState(""),
            placeholder = "Placeholder"
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TaskyTextFieldLightFilledPreview(
) {
    MaterialTheme {
        TaskyTextField(
            state = TextFieldState("Some text"),
            placeholder = "Placeholder",
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TaskyTextFieldLightErrorPreview(
) {
    MaterialTheme {
        TaskyTextField(
            state = TextFieldState("Some text"),
            placeholder = "Placeholder",
            isError = true
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TaskyTextFieldDarkNormalPreview(
) {
    MaterialTheme(colorScheme = darkColorScheme()) {
        TaskyTextField(
            state = TextFieldState(""),
            placeholder = "Placeholder"
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TaskyTextFieldDarkFilledPreview(
) {
    MaterialTheme(colorScheme = darkColorScheme()) {
        TaskyTextField(
            state = TextFieldState("Some text"),
            placeholder = "Placeholder"
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TaskyTextFieldDarkErrorPreview(
) {
    MaterialTheme(colorScheme = darkColorScheme()) {
        TaskyTextField(
            state = TextFieldState("Some text"),
            placeholder = "Placeholder",
            isError = true
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TaskySecretTextFieldLightNormalPreview(
) {
    MaterialTheme {
        TaskyTextField(
            state = TextFieldState(""),
            placeholder = "Placeholder"
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TaskySecretTextFieldLightFilledPreview(
) {
    MaterialTheme {
        TaskyPasswordField(
            state = TextFieldState("secret"),
            placeholder = "Placeholder"
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TaskySecretTextFieldLightErrorPreview(
) {
    MaterialTheme {
        TaskyPasswordField(
            state = TextFieldState("secret"),
            placeholder = "Placeholder",
            isError = true
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TaskySecretTextFieldLightRevealedPreview(
) {
    MaterialTheme {
        TaskyPasswordField(
            state = TextFieldState("secret"),
            placeholder = "Placeholder"
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TaskySecretTextFieldDarkNormalPreview(
) {
    MaterialTheme(colorScheme = darkColorScheme()) {
        TaskyTextField(
            state = TextFieldState(""),
            placeholder = "Placeholder"
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TaskySecretTextFieldDarkFocusedPreview(
) {
    MaterialTheme(colorScheme = darkColorScheme()) {
        TaskyPasswordField(
            state = TextFieldState("secret"),
            placeholder = "Placeholder"
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TaskySecretTextFieldDarkErrorPreview(
) {
    MaterialTheme(colorScheme = darkColorScheme()) {
        TaskyPasswordField(
            state = TextFieldState("secret"),
            placeholder = "Placeholder"
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TaskySecretTextFieldDarkRevealedPreview(
) {
    MaterialTheme(colorScheme = darkColorScheme()) {
        TaskyPasswordField(
            state = TextFieldState("secret"),
            placeholder = "Placeholder"
        )
    }
}
