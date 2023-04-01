package com.example.timieu2023.features.home.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.timieu2023.features.home.data.enum.EventCategory

@Entity(tableName = "event")
data class EventEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "event_name") val eventName: String?,
    @ColumnInfo(name = "event_description") val eventDescription: String?,
    @ColumnInfo(name = "event_category") val eventCategory: String?,
    @ColumnInfo(name = "event_date") val eventDate : String?,
    @ColumnInfo(name = "event_time") val eventTime: String?,
    @ColumnInfo(name = "event_photo_url") val photoUrl: String?
)
