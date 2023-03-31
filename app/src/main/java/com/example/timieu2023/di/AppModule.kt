package com.example.timieu2023.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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

}