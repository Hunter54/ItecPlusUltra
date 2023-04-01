package com.example.timieu2023.features.scanner.data

import androidx.room.*
import com.example.timieu2023.features.home.data.EventEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface LocationsDao{

    @Query("SELECT * FROM locations")
    fun getAllLocations(): Flow<List<LocationEntity>>

    @Query("SELECT * FROM locations WHERE location_visited")
    fun getAllVisitedLocations(): Flow<List<LocationEntity>>

    @Update
    suspend fun updateLocation(location:LocationEntity)

    @Query("UPDATE locations SET location_visited = :visited WHERE id = :id")
    suspend fun updateLocationVisitedStatus(id: String, visited: Boolean = true): Int

    @Query("SELECT * FROM locations WHERE id = :locationId ")
    suspend fun getLocationById( locationId: String): LocationEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocations(vararg location: LocationEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocations( locations: List<LocationEntity>)

    @Delete
    suspend fun delete(eventEntity: LocationEntity)

}