package com.example.timieu2023.features.scanner.data

import javax.inject.Inject

class LocationsRepository @Inject constructor(
    private val locationsDao: LocationsDao,
    private val locationsDataSource: LocationsDataSource
) {

    val userVisitedLocations = locationsDao.getAllLocations()

    suspend fun fetchAndSaveVisitedLocation(locationId: String) {
        val location = locationsDataSource.getLocation(locationId).mapToLocationEntity()
        locationsDao.insertLocations(location)
    }

}