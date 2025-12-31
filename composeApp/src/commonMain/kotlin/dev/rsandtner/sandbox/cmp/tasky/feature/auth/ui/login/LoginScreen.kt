package dev.rsandtner.sandbox.cmp.tasky.feature.auth.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.rsandtner.sandbox.cmp.tasky.core.ui.component.TaskyButton
import dev.rsandtner.sandbox.cmp.tasky.core.ui.component.TaskyLink
import dev.rsandtner.sandbox.cmp.tasky.core.ui.component.TaskyPasswordField
import dev.rsandtner.sandbox.cmp.tasky.core.ui.component.TaskyTextField
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import tasky.composeapp.generated.resources.*

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    modifier: Modifier = Modifier,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LoginScreenContent(
        state = state,
        modifier = modifier,
    )
}

@Composable
private fun LoginScreenContent(
    state: LoginState,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets.statusBars
            .union(WindowInsets.displayCutout)
            .union(WindowInsets.ime)
    ) { innerPadding ->
        Surface(
//        color = MaterialTheme.colorScheme.background,
            color = Color.Black,
            modifier = Modifier.padding(innerPadding)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {

                Spacer(Modifier.height(32.dp))
                Text(
                    text = stringResource(Res.string.welcome_back),
                    style = MaterialTheme.typography.headlineLarge,
//                color = MaterialTheme.colorScheme.onBackground,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(32.dp))

                Surface(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(topStart = 38.dp, topEnd = 38.dp),
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                            .padding(horizontal = 16.dp, vertical = 28.dp),
                    ) {
                        TaskyTextField(
                            state = state.email,
                            placeholder = stringResource(Res.string.email_placeholder),
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        TaskyPasswordField(
                            state = state.password,
                            isPasswordVisible = state.passwordVisible,
                            onToggleVisibility = { TODO("handle password visibility toggle") },
                            placeholder = stringResource(Res.string.password_placeholder),
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(Modifier.height(32.dp))

                        TaskyButton(
                            modifier = Modifier.fillMaxWidth(),
                            text = stringResource(Res.string.login).uppercase(),
                            onClick = { TODO("handle login click") },
                        )

                        Spacer(Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            Text(
                                text = stringResource(Res.string.no_account).uppercase(),
                                style = MaterialTheme.typography.labelSmall,
                            )
                            Spacer(modifier = Modifier.width(2.dp))
                            TaskyLink(
                                text = stringResource(Res.string.sign_up).uppercase(),
                                onClick = { TODO("handle register click") },
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun LoginScreenPreview(
) {
    MaterialTheme {
        LoginScreenContent(
            state = LoginState()
        )
    }
}
