package dev.rsandtner.sandbox.cmp.tasky.core.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TaskyTextField(
    state: TextFieldState,
    placeholder: String? = null,
    isError: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    modifier: Modifier = Modifier,
) {
    TaskyTextFieldBase(
        modifier = modifier,
        isError = isError,
    ) { style, interactionSource, taskyPlaceholder ->
        BasicTextField(
            state = state,
            modifier = style,
            interactionSource = interactionSource,
            textStyle = MaterialTheme.typography.bodyMedium,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            decorator = { content ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    taskyPlaceholder(placeholder, state)
                    content()
                }
            },
        )
    }
}

@Composable
@Preview
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
@Preview
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
@Preview
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
@Preview
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
@Preview
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
@Preview
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

