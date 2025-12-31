package dev.rsandtner.sandbox.cmp.tasky.feature.auth.ui.login

import androidx.compose.foundation.text.input.TextFieldState

data class LoginState(
    val email: TextFieldState = TextFieldState(),
    val password: TextFieldState = TextFieldState(),
    val passwordVisible: Boolean = false,
)
