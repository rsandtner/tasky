package dev.rsandtner.sandbox.cmp.tasky.core.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

enum class TaskyButtonType(
    val colors: @Composable () -> ButtonColors,
    val border: @Composable () -> BorderStroke?
) {
    Primary(
        colors = {
            ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = .7f),
                disabledContentColor = MaterialTheme.colorScheme.onPrimary
            )
        },
        border = { null }
    ),
    Secondary(
        colors = {
            ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onSurface,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = .7f)
            )
        },
        border = {
            BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = .7f),
            )
        }
    )
}

@Composable
fun TaskyButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    type: TaskyButtonType = TaskyButtonType.Primary,
    enabled: Boolean = true,
    loading: Boolean = false,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled && !loading,
        colors = type.colors(),
        border = type.border(),
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.alpha(if (loading) 1f else 0f),
            )
            Text(
                modifier = Modifier.alpha(if (loading) 0f else 1f),
                text = text,
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }
}

@Composable
@Preview
fun TaskyButtonPrimaryPreview() {
    MaterialTheme {
        TaskyButton(text = "Button",
            onClick = {})
    }
}

@Composable
@Preview
fun TaskyButtonPrimaryDisabledPreview() {
    MaterialTheme {
        TaskyButton(
            text = "Button",
            onClick = {},
            enabled = false
        )
    }
}

@Composable
@Preview
fun TaskyButtonPrimaryLoadingPreview() {
    MaterialTheme {
        TaskyButton(
            text = "Button",
            onClick = {},
            loading = true
        )
    }
}

@Composable
@Preview(showBackground = true)
fun TaskyButtonSecondaryPreview() {
    MaterialTheme {
        TaskyButton(
            text = "Button",
            type = TaskyButtonType.Secondary,
            onClick = {},
        )
    }
}
@Composable
@Preview(showBackground = true)
fun TaskyButtonSecondaryDisabledPreview() {
    MaterialTheme {
        TaskyButton(
            text = "Button",
            type = TaskyButtonType.Secondary,
            onClick = {},
            enabled = false
        )
    }
}
@Composable
@Preview(showBackground = true)
fun TaskyButtonSecondaryLoadingPreview() {
    MaterialTheme {
        TaskyButton(
            text = "Button",
            type = TaskyButtonType.Secondary,
            onClick = {},
            loading = true
        )
    }
}




