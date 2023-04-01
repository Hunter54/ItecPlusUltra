package com.example.timieu2023.features.home.data

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class WeatherDataDto(
    val time: List<String>,
    @SerialName(value = "temperature_2m")
    val temperatures: List<Double>,
    @SerialName(value = "weathercode")
    val weatherCodes: List<Int>,
    @SerialName(value = "pressure_msl")
    val pressures: List<Double>,
    @SerialName(value = "windspeed_10m")
    val windSpeeds: List<Double>,
    @SerialName(value = "relativehumidity_2m")
    val humidities: List<Double>
)