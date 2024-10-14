package xyz.teamgravity.datastorepreferencesmultiplatformdemo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import datastorepreferencesmultiplatformdemo.composeapp.generated.resources.Res
import datastorepreferencesmultiplatformdemo.composeapp.generated.resources.increment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    preferences: DataStore<Preferences>,
    scope: CoroutineScope = rememberCoroutineScope()
) {
    MaterialTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                space = 10.dp,
                alignment = Alignment.CenterVertically
            ),
            modifier = Modifier.fillMaxSize()
        ) {
            val key = remember { intPreferencesKey("count") }
            val count by preferences
                .data
                .map { it[key] ?: 0 }
                .collectAsState(0)

            Text(
                text = count.toString(),
                textAlign = TextAlign.Center,
                fontSize = 50.sp
            )
            Button(
                onClick = {
                    scope.launch {
                        preferences.edit { it[key] = count + 1 }
                    }
                }
            ) {
                Text(
                    text = stringResource(Res.string.increment)
                )
            }
        }
    }
}