package com.example.timieu2023.features.home.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class EventRepository @Inject constructor(
    private val eventDao: EventDao,
    private val eventDataSource: EventDataSource,
) {

    val events = eventDao.getAll()

    suspend fun getEvent(id: String): EventEntity {
        return eventDao.getEventById(id)
    }

    suspend fun refreshEvents() {
        val events = eventDataSource.getAllEvents().map {
            it.mapToEventEntity()
        }
        eventDao.insertAll(events)
    }



}