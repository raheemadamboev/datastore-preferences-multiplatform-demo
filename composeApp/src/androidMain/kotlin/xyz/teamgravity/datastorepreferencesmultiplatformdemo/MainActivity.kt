package xyz.teamgravity.datastorepreferencesmultiplatformdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val preferences = createDataStore(applicationContext.filesDir.resolve(DATA_STORE_NAME).absolutePath)

        setContent {
            App(
                preferences = preferences
            )
        }
    }
}