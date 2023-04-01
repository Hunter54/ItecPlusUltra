package com.example.timieu2023.features.home.domain

interface WeatherRepository {
    suspend fun getWeatherData(): Resource<WeatherInfo>
}