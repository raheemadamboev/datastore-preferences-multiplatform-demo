package xyz.teamgravity.datastorepreferencesmultiplatformdemo

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

fun createDataStore(path: String): DataStore<Preferences> {
    return PreferenceDataStoreFactory.createWithPath(
        produceFile = { path.toPath() }
    )
}

const val DATA_STORE_NAME = "preferences.preferences_pb"