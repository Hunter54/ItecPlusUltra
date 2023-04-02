package com.example.timieu2023.features.home.data

import com.example.timieu2023.features.home.data.enum.EventCategory


data class EventDTO(
    val id: String,
    val eventName: String?,
    val eventDescription: String?,
    val eventCategory: String?,
    val eventLocationName: String?,
    val eventDate: String?,
    val eventTime: String?,
    val photoUrl: String?,
    val lat: String?,
    val long: String?
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
            this.photoUrl,
            this.lat,
            this.long
        )
    }
}
