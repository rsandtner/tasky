package dev.rsandtner.sandbox.cmp.tasky.core.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TaskyLink(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Text(
        text = text,
        style = MaterialTheme.typography.labelSmall,
        color = Color(0xFF8E97FD),
        modifier = modifier
            .clickable(onClick = onClick)
    )
}

@Composable
@Preview(showBackground = true)
fun TaskyLinkPreview() {
    MaterialTheme {
        TaskyLink(text = "Link", onClick = {})
    }
}
