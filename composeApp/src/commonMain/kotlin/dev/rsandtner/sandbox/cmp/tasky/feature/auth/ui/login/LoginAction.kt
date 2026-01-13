package dev.rsandtner.sandbox.cmp.tasky.feature.auth.ui.login

sealed interface LoginAction {
    object Login : LoginAction
}
