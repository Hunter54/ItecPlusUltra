package com.example.timieu2023.features.home.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.timieu2023.features.scanner.data.LocationEntity
import com.example.timieu2023.features.scanner.data.LocationsDao

@Database(entities = [EventEntity::class, LocationEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao
    abstract fun locationsDao(): LocationsDao
}
