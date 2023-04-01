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
                "https://lh5.googleusercontent.com/p/AF1QipP_fFDvVvvNt0lCWrqbxrI8u1X2OYBDCIMhxNla=w408-h272-k-no"
            )
        )
    }
}