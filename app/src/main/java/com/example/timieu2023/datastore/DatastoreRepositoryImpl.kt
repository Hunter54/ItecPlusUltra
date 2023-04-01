package com.example.timieu2023.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject

const val PREFERENCE_NAME = "MyDataStore"

class DatastoreRepositoryImpl @Inject constructor(
   @ApplicationContext
   val context: Context
) : DatastoreRepository {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCE_NAME)

    override suspend fun write(key: String, value: String) {
        context.dataStore.edit { pref -> pref[stringPreferencesKey(key)] = value }
    }

    override suspend fun read(key: String): Flow<String> {
        return context.dataStore.data.map { pref ->
            pref[stringPreferencesKey(key)] ?: ""
        }
    }

}