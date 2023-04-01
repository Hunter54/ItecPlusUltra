package com.example.timieu2023.features.scanner.data

import com.example.ApiState
import com.example.timieu2023.R
import javax.inject.Inject

class LocationsRepository @Inject constructor(
    private val locationsDao: LocationsDao,
    private val locationsDataSource: LocationsDataSource
) {

    val allLocations = locationsDao.getAllLocations()

    val visitedLocations = locationsDao.getAllVisitedLocations()

    suspend fun addVisitedLocation(locationId: String): ApiState<LocationEntity> {
        val result = locationsDao.updateLocationVisitedStatus(locationId)
        return if (result == 0) {
            ApiState.Failed(R.string.failed_confirm_visit)
        } else ApiState.Success(locationsDao.getLocationById(locationId))
    }

    suspend fun fetchLocations() {
        val location = locationsDataSource.getLocations().map {
            it.mapToLocationEntity()
        }
        locationsDao.insertLocations(location)
    }

}