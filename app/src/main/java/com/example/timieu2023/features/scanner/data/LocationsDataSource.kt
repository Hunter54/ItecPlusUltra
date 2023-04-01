package com.example.timieu2023.features.scanner.data

interface LocationsDataSource {

    suspend fun getLocation(locationId: String): LocationDto

}