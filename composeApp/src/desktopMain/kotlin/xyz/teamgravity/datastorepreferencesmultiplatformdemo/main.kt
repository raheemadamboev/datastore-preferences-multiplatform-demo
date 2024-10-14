package xyz.teamgravity.datastorepreferencesmultiplatformdemo

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() {
    val preferences = createDataStore(DATA_STORE_NAME)
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "DataStorePreferencesMultiplatformDemo",
        ) {
            App(
                preferences = preferences
            )
        }
    }
}