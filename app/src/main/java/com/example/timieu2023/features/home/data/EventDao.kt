package com.example.timieu2023.features.home.data

import androidx.room.*
import com.google.common.net.HttpHeaders.FROM
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {
    @Query("SELECT * FROM event")
    fun getAll(): Flow<List<EventEntity>>

    @Query("SELECT * FROM event WHERE id = :eventId ")
    suspend fun getEventById( eventId: String): EventEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg events: EventEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(events: List<EventEntity>)

    @Delete
    suspend fun delete(eventEntity: EventEntity)

}