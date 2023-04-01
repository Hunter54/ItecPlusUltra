package com.example.timieu2023.features.scanner.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locations")
data class LocationEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "location_name") val locationName: String="",
    @ColumnInfo(name = "location_description") val locationDescription: String="",
    @ColumnInfo(name = "location_longitude") val locationLongitude: Double,
    @ColumnInfo(name = "location_latitude") val locationLatitude: Double,
    @ColumnInfo(name = "location_photo_url") val photoUrl: String?,
    @ColumnInfo(name = "location_visited") val locationVisited: Boolean = false
)
