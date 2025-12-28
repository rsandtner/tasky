package dev.rsandtner.sandbox.cmp.tasky

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "tasky",
    ) {
        App()
    }
}