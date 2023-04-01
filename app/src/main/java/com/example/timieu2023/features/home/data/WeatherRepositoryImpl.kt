package com.example.timieu2023.features.home.data

import com.example.timieu2023.features.home.data.mapper.toWeatherInfo
import com.example.timieu2023.features.home.domain.Resource
import com.example.timieu2023.features.home.domain.WeatherInfo
import com.example.timieu2023.features.home.domain.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    override suspend fun getWeatherData(): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = 45.75, long = 21.23
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}