package com.example.timieu2023.di

import android.app.Application
import android.content.Context
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.timieu2023.datastore.DatastoreRepository
import com.example.timieu2023.datastore.DatastoreRepositoryImpl
import com.example.timieu2023.features.eventsmap.StringDecoder
import com.example.timieu2023.features.eventsmap.UriDecoder
import com.example.timieu2023.features.home.data.AppDatabase
import com.example.timieu2023.features.home.data.EventDao
import com.example.timieu2023.features.home.data.EventDataSource
import com.example.timieu2023.features.home.data.EventDataSourceMocked
import com.example.timieu2023.features.home.data.EventRepository
import com.example.timieu2023.features.home.data.WeatherApi
import com.example.timieu2023.features.home.data.WeatherRepositoryImpl
import com.example.timieu2023.features.home.data.serializaer.kotlinxConverterFactory
import com.example.timieu2023.features.home.domain.WeatherRepository
import com.example.timieu2023.features.scanner.data.LocationsDao
import com.example.timieu2023.features.scanner.data.LocationsDataSource
import com.example.timieu2023.features.scanner.data.LocationsMockedDataSource
import com.example.timieu2023.features.scanner.data.LocationsRepository
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
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-name"
        ).build()
    }

    @Singleton
    @Provides
    fun provideEventDao(database: AppDatabase): EventDao {
        return database.eventDao()
    }

    @Singleton
    @Provides
    fun provideLocationsDao(database: AppDatabase): LocationsDao {
        return database.locationsDao()
    }

    @Singleton
    @Provides
    fun provideLocationsDataSource(): LocationsDataSource {
        return LocationsMockedDataSource()
    }

    @Singleton
    @Provides
    fun provideLocationsRepository(locationsDao: LocationsDao, locationsDataSource: LocationsDataSource): LocationsRepository {
        return LocationsRepository(locationsDao,locationsDataSource)
    }

    @Singleton
    @Provides
    fun provideEventsRepository(eventDao: EventDao, eventDataSource: EventDataSource): EventRepository {
        return EventRepository(eventDao, eventDataSource)
    }

    @Singleton
    @Provides
    fun provideEventDataSource(): EventDataSource {
        return EventDataSourceMocked()
    }

    @Singleton
    @Provides
    fun provideDatastore(@ApplicationContext applicationContext: Context): DatastoreRepository {
        return DatastoreRepositoryImpl(applicationContext)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(
        weatherApi: WeatherApi
    ): WeatherRepository =
        WeatherRepositoryImpl(
            api = weatherApi
        )

    @Singleton
    @Provides
    fun bindStringDecoder(): StringDecoder = UriDecoder()

}