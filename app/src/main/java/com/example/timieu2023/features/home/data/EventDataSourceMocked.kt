package com.example.timieu2023.features.home.data

class EventDataSourceMocked() : EventDataSource {
    override suspend fun getAllEvents(): List<EventDTO> {
        return listOf<EventDTO>(
            EventDTO(
                id = "Event1",
                eventName = "Analog Mania XI Opening Weekend",
                eventDescription = "Built in 1929 and arranged as \"English gardens\" the Roses park was for decades an iconic place of Timisoara.",
                eventCategory = "",
                eventLocationName = "Timisoara Students' House of Culture",
                eventDate = "April 2 2023,",
                eventTime = "18:00 pm",
                photoUrl = "https://timisoara2023.eu/media/images/27905aaa-1d42-4649-b2e0-93b2a97495d0.width-640.jpg",
                lat = "45.74",
                long = "21.21"
            ),
            EventDTO(
                id = "Event2",
                eventName = "Treasure Hunt „La UVT, Cultura este Capitală!”",
                eventDescription = "",
                eventCategory = "",
                eventLocationName = "Timisoara Students' House of Culture",
                eventDate = "April 6 2023,",
                eventTime = "10:00 am",
                photoUrl = "https://timisoara2023.eu/media/images/220a68ab-aeec-48aa-9348-3f197e57eaca.width-640.jpg",
                lat = "45.74",
                long = "21.23"
            ),
            EventDTO(
                id = "Event3",
                eventName = "Science & Imagination Caravan",
                eventDescription = "",
                eventCategory = "",
                eventLocationName = "Timisoara Students' House of Culture",
                eventDate = "April 7 2023,",
                eventTime = "15:00 pm",
                photoUrl = "https://timisoara2023.eu/media/images/74600d5d-61f3-4c4c-93e7-6b3a62608ebb.width-640.jpg",
                lat = "45.74",
                long = "21.21"
            ),
            EventDTO(
                id = "Event4",
                eventName = "Cargo Berlin – Timișoara",
                eventDescription = "",
                eventCategory = "",
                eventLocationName = "Bastionul Maria Theresia",
                eventDate = "April 7 2023,",
                eventTime = "19:00 pm",
                photoUrl = "https://timisoara2023.eu/media/images/801d3ca1-07fd-4b02-bd19-10579d816664.width-640.jpg",
                lat = "45.757",
                long = "21.233"
            ),
            EventDTO(
                id = "Event5",
                eventName = "CODRU Planting",
                eventDescription = "",
                eventCategory = "",
                eventLocationName = "Două Dealuri",
                eventDate = "April 8 2023,",
                eventTime = "10:00 am",
                photoUrl = "https://timisoara2023.eu/media/images/8fcfce87-f1df-4088-9694-b1a49453c4d8.width-640.png",
                lat = "45.84",
                long = "21.52"
            ),
            EventDTO(
                id = "Event6",
                eventName = "Ideas that change the world",
                eventDescription = "",
                eventCategory = "",
                eventLocationName = "West University of Timisoara - Aula Magna",
                eventDate = "April 11 2023,",
                eventTime = "10:00 am",
                photoUrl = "https://timisoara2023.eu/media/images/d4e74dc0-26d5-4b83-b877-7a739d5cd8b3.width-640.jpg",
                lat = "45.74",
                long = "21.23"
            ),
            EventDTO(
                id = "Event7",
                eventName = "Gypsy Groove",
                eventDescription = "",
                eventCategory = "",
                eventLocationName = "Liberty Square",
                eventDate = "April 22 2023,",
                eventTime = "20:00 pm",
                photoUrl = "https://timisoara2023.eu/media/images/21e8aebe-5b7d-4ee8-809d-95dec0480ac8.width-640.jpg",
                lat = "45.745",
                long = "21.227"
            ),
        )
    }
}