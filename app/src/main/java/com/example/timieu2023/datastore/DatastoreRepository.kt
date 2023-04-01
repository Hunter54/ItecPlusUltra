package com.example.timieu2023.datastore

import kotlinx.coroutines.flow.Flow

interface DatastoreRepository {
    suspend fun write(key: String, value: String)
    suspend fun read(key: String): Flow<String>

}