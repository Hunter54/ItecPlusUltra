package com.example.timieu2023.features.home.presentation.weather

import com.example.timieu2023.features.home.domain.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
