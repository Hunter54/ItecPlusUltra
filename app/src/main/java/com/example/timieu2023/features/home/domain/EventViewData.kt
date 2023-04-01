package com.example.timieu2023.features.home.domain

import com.example.timieu2023.features.home.data.enum.EventCategory

data class EventViewData(
    val eventName: String? = "",
    val eventCategory: String? = "",
    val eventDescription: String? = "",
    val imageRef: String? = "",
)
