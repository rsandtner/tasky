package dev.rsandtner.sandbox.cmp.tasky.core.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.rsandtner.sandbox.cmp.tasky.core.ui.theme.TaskyTheme
import dev.rsandtner.sandbox.cmp.tasky.core.ui.theme.extended
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
        color = MaterialTheme.colorScheme.extended.link,
        modifier = modifier
            .clickable(onClick = onClick)
    )
}

@Composable
@Preview(showBackground = true)
private fun TaskyLinkPreview() {
    TaskyTheme {
        TaskyLink(text = "Link", onClick = {})
    }
}
