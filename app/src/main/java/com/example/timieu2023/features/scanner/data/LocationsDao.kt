package com.example.timieu2023.features.scanner.data

import androidx.room.*
import com.example.timieu2023.features.home.data.EventEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface LocationsDao{

    @Query("SELECT * FROM locations")
    fun getAllLocations(): Flow<List<LocationEntity>>

    @Update
    suspend fun changeLocation(location:LocationEntity)

    @Query("SELECT * FROM locations WHERE id = :locationId ")
    suspend fun getLocationById( locationId: String): LocationEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocations(vararg users: LocationEntity)

    @Delete
    suspend fun delete(eventEntity: LocationEntity)
}