package dev.rsandtner.sandbox.cmp.tasky.feature.auth.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class LoginViewModel : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun onAction(action: LoginAction) {
        when (action) {
            LoginAction.Login -> handleLogin()
        }
    }

    private fun handleLogin() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            delay(5.seconds)
            _state.update { it.copy(isLoading = false) }
        }
    }
}
