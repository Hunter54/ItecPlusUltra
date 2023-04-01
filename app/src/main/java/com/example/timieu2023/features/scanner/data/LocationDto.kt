package com.example.timieu2023.features.scanner.data

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.example.timieu2023.features.home.data.EventEntity

data class LocationDto(
    val id: String,
    val locationName: String,
    val locationDescription: String,
    val locationLongitude: Double,
    val locationLatitude: Double,
    val photoUrl: String?
) {
    fun mapToLocationEntity(): LocationEntity {
        return LocationEntity(
            this.id,
            this.locationName,
            this.locationDescription,
            this.locationLongitude,
            this.locationLatitude,
            this.photoUrl,
            false
        )
    }
}
