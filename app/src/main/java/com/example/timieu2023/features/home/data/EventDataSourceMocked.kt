package com.example.timieu2023.features.home.data

import com.example.timieu2023.features.home.data.enum.EventCategory

class EventDataSourceMocked() : EventDataSource {
    override suspend fun getAllEvents(): List<EventDTO> {
        return listOf<EventDTO>(
            EventDTO(
                id = "Event1",
                eventName = "Roses Park",
                eventDescription = "Built in 1929 and arranged as \"English gardens\" the Roses park was for decades an iconic place of Timisoara.",
                eventCategory = "",
                eventDate = null,
                eventTime = null,
                photoUrl = "https://www.presadetimis.ro/wp-content/uploads/2023/03/WhatsApp-Image-2023-03-24-at-14.16.06.jpeg"
            ),
            EventDTO(
                id = "Event2",
                eventName = "Roses Park",
                eventDescription = "Built in 1929 and arranged as \"English gardens\" the Roses park was for decades an iconic place of Timisoara.",
                eventCategory = "",
                eventDate = null,
                eventTime = null,
                photoUrl = "https://www.presadetimis.ro/wp-content/uploads/2023/03/WhatsApp-Image-2023-03-24-at-14.16.06.jpeg"
            ),
            EventDTO(
                id = "Event3",
                eventName = "Roses Park",
                eventDescription = "Built in 1929 and arranged as \"English gardens\" the Roses park was for decades an iconic place of Timisoara.",
                eventCategory = "",
                eventDate = null,
                eventTime = null,
                photoUrl = "https://www.presadetimis.ro/wp-content/uploads/2023/03/WhatsApp-Image-2023-03-24-at-14.16.06.jpeg"
            )
        )
    }
}