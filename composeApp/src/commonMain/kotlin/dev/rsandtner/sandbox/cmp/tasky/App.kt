package dev.rsandtner.sandbox.cmp.tasky

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import dev.rsandtner.sandbox.cmp.tasky.core.ui.theme.TaskyTheme
import dev.rsandtner.sandbox.cmp.tasky.feature.auth.ui.login.LoginScreen
import dev.rsandtner.sandbox.cmp.tasky.feature.auth.ui.login.LoginViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    TaskyTheme {
        val viewModel = remember { LoginViewModel() }
        LoginScreen(
            viewModel = viewModel,
        )
    }
}
