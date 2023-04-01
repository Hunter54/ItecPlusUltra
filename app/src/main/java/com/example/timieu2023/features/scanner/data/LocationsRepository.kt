package com.example.timieu2023.features.scanner.data

import javax.inject.Inject

class LocationsRepository @Inject constructor(
    private val locationsDao: LocationsDao,
    private val locationsDataSource: LocationsDataSource
) {

    val allLocations = locationsDao.getAllLocations()

    val visitedLocations = locationsDao.getAllVisitedLocations()

    suspend fun addVisitedLocation(locationId: String){
        locationsDao.updateLocationVisitedStatus(locationId)
    }

    suspend fun fetchLocations() {
        val location = locationsDataSource.getLocations().map{
            it.mapToLocationEntity()
        }
        locationsDao.insertLocations(location)
    }

}