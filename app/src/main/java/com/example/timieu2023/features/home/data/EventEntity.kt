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
    @ColumnInfo(name = "event_running_date") val eventRunningDate : String?,
    @ColumnInfo(name = "event_time") val eventTime: String?
)
