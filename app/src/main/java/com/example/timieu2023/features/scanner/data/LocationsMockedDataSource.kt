package com.example.timieu2023.features.scanner.data

class LocationsMockedDataSource : LocationsDataSource {
    override suspend fun getLocations(): List<LocationDto> {
        return listOf(
            LocationDto(
                "1234567",
                "Bastion",
                "Old Location for the old fortress",
                45.757051,
                21.234220,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Bastionul_Theresia_ansamblu.jpg/440px-Bastionul_Theresia_ansamblu.jpg"
            )
        )
    }
}