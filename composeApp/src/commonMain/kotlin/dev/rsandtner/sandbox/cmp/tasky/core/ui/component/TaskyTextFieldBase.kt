package dev.rsandtner.sandbox.cmp.tasky.core.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
internal fun TaskyTextFieldBase(
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    content: @Composable (Modifier,
                          MutableInteractionSource,
                          TaskyPlaceholder) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    val textFieldShape = RoundedCornerShape(10.dp)
    val style = modifier
        .background(MaterialTheme.colorScheme.surfaceContainerHigh, textFieldShape)
        .border(
            width = 1.dp,
            color = when {
                isError -> MaterialTheme.colorScheme.error
                isFocused -> MaterialTheme.colorScheme.outline
                else -> Color.Transparent
            },
            shape = textFieldShape
        )
        .padding(horizontal = 20.dp, vertical = 12.dp)
        .heightIn(min = 24.dp) // without a min height, the textfield gets a little bit smaller when starting to type on macOS

    content(style, interactionSource, { placeholder, state -> Placeholder(placeholder, state, isFocused)})
}

internal typealias TaskyPlaceholder = @Composable (placeholder: String?, state: TextFieldState) -> Unit

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
