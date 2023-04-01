package com.example.timieu2023.features.home.data

import androidx.room.ColumnInfo


data class EventDTO(
    val id: String,
    val eventName: String?,
    val eventDescription: String?,
    val eventCategory: String?,
    val eventLocationName: String?,
    val eventDate: String?,
    val eventTime: String?,
    val photoUrl: String?
) {
    fun mapToEventEntity(): EventEntity {
        return EventEntity(
            this.id,
            this.eventName,
            this.eventDescription,
            this.eventCategory,
            this.eventLocationName,
            this.eventDate,
            this.eventTime,
            this.photoUrl
        )
    }
}
