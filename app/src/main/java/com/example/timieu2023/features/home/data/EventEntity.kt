package com.example.timieu2023.features.home.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event")
data class EventEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "event_name") val eventName: String?,
    @ColumnInfo(name = "event_description") val eventDescription: String?,
    @ColumnInfo(name = "event_category") val eventCategory: String?,
    @ColumnInfo(name = "event_location_name") val eventLocationName: String?,
    @ColumnInfo(name = "event_date") val eventDate : String?,
    @ColumnInfo(name = "event_time") val eventTime: String?,
    @ColumnInfo(name = "event_photo_url") val photoUrl: String?,
    @ColumnInfo(name = "event_lat") val eventLat: String?,
    @ColumnInfo(name = "event_long") val eventLong: String?
)
