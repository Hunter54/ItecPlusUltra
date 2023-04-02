package com.example.timieu2023.features.home.domain

data class EventViewData(
    val eventName: String? = "",
    val eventCategory: String? = "",
    val eventDate: String? = "",
    val eventTime: String? = "",
    val eventNameLocation: String? = "",
    val eventDescription: String? = "",
    val imageRef: String? = "",
    val lat: String,
    val long: String
)
