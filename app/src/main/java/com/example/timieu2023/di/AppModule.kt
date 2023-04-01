package com.example.timieu2023.di

import android.app.Application
import com.example.timieu2023.features.home.data.WeatherApi
import com.example.timieu2023.features.home.data.WeatherRepositoryImpl
import com.example.timieu2023.features.home.data.serializaer.kotlinxConverterFactory
import com.example.timieu2023.features.home.domain.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/")
            .addConverterFactory(kotlinxConverterFactory())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(
        weatherApi: WeatherApi
    ): WeatherRepository =
        WeatherRepositoryImpl(
            api = weatherApi
        )
}