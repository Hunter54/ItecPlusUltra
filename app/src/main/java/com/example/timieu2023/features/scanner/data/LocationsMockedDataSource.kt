package com.example.timieu2023.features.scanner.data

class LocationsMockedDataSource : LocationsDataSource {
    override suspend fun getLocations(): List<LocationDto> {
        return listOf(
            LocationDto(
                "1234567",
                "Bastionul Theresia",
                "Bastionul Theresia este singurul bastion care mai există din cetatea Timișoarei din perioada apartenenței Banatului la Imperiul Austriac. Fiind singurul bastion din Timișoara, mai este cunoscut de timișoreni sub numele de Bastionul Cetății. Bastionul a fost reabilitat în perioada 2008–2010. ",
                21.234220,
                45.757051,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Bastionul_Theresia_ansamblu.jpg/440px-Bastionul_Theresia_ansamblu.jpg"
            ),
            LocationDto(
                "12345678",
                "Orthodox Metropolitan Cathedral",
                "The Orthodox Cathedral, also known as the Metropolitan Cathedral, is a Romanian Orthodox church in Timișoara. The cathedral is the seat of the Archbishopric of Timișoara and the Metropolis of Banat. It is dedicated to the Three Holy Hierarchs, Basil the Great, Gregory the Theologian and John Chrysostom.\n" +
                        "Built on an area of 1,542 m2, it has 11 towers, of which the central one has a height of 90.5 m, making it the second tallest church in Romania, after the People's Salvation Cathedral in Bucharest. The cathedral is listed in the National Register of Historic Monuments.",
                21.224463,
                45.750974,
                photoUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Timi%C8%99oara_Orthodox_Cathedral.jpg/440px-Timi%C8%99oara_Orthodox_Cathedral.jpg"
            )
        )
    }
}