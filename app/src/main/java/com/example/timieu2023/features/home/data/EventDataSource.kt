package com.example.timieu2023.features.home.data

interface EventDataSource {

    suspend fun getAllEvents(): List<EventDTO>

}