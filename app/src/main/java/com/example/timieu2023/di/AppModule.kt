package com.example.timieu2023.di

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.timieu2023.features.home.data.AppDatabase
import com.example.timieu2023.features.home.data.EventDao
import com.example.timieu2023.features.home.data.EventDataSource
import com.example.timieu2023.features.home.data.EventDataSourceMocked
import com.example.timieu2023.features.home.data.WeatherApi
import com.example.timieu2023.features.home.data.WeatherRepositoryImpl
import com.example.timieu2023.features.home.data.serializaer.kotlinxConverterFactory
import com.example.timieu2023.features.home.domain.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
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
    fun provideCoroutineScope(): CoroutineScope = ProcessLifecycleOwner.get().lifecycleScope

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java, "database-name"
        ).build()
    }

    @Singleton
    @Provides
    fun provideEventDao(database: AppDatabase): EventDao {
        return database.userDao()
    }

    @Singleton
    @Provides
    fun provideEventDataSource(): EventDataSource{
        return EventDataSourceMocked()
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