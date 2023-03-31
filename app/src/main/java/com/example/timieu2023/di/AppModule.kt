package com.example.timieu2023.di

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.timieu2023.features.home.data.AppDatabase
import com.example.timieu2023.features.home.data.EventDao
import com.example.timieu2023.features.home.data.EventDataSource
import com.example.timieu2023.features.home.data.EventDataSourceMocked
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

//    @Singleton
//    @Provides
//    fun provideEventsRepository(
//        dataSource: EventsDataSource
//    ): EventsRepository = EventsRepositoryImpl(dataSource)

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

}