package com.example.timieu2023.features.home.data

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class WeatherDto(
    @SerialName(value = "hourly")
    val weatherData: WeatherDataDto
)