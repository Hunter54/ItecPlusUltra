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
            ),
            LocationDto(
                "12345679",
                "Roses Park",
                "Roses Park, previously known as Rosarium or Ștefan Plavăț Park of Culture and Leisure, is an urban park in Timișoara, located north of the Bega River. he park was established and opened in 1891 on the occasion of the Agro-Industrial Exhibition in Southern Hungary. The floral arrangements were made by gardeners Wilhelm Mühle, Franz Niemetz and Benő Agátsy and were also visited by Emperor Franz Joseph. The park bore the emperor's name, but after World War I it was renamed Rosarium. ",
                21.234312,
                45.750527,
                photoUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/2/20/Parcul_Rozelor_Timisoara_-_entrance.jpg/600px-Parcul_Rozelor_Timisoara_-_entrance.jpg"
            ),
            LocationDto("12345677",
            "Timișoara Art Museum",
            "he Baroque Palace is a monumental palace in the historic centre of the Romanian city of Timișoara. One of the representative buildings of 18th-century Timișoara, the Baroque Palace today houses the city's National Museum of Art. The richly decorated palace consists of two floors and a mansard, as well as two entrance gates designed in the Viennese Baroque style. The Baroque Hall on the first floor hosted festivities occasioned by the visit of emperors (Joseph II, Franz Joseph I, etc.), kings (Ferdinand I, etc.) and prelates, as well as important cultural figures (such as musicians Franz Liszt, Johannes Brahms, Pablo Sarasate, George Enescu, etc.)",
                21.229336,
                45.757492,
                photoUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/Timi%C8%99oara_-_Palatul_Vechii_Prefecturi_%2844188365354%29.jpg/500px-Timi%C8%99oara_-_Palatul_Vechii_Prefecturi_%2844188365354%29.jpg"
            ),
            LocationDto("12345676",
            "St. George Cathedral",
            "The St. George Cathedral, colloquially known as the Roman Catholic Dome, is the cathedral of the Roman Catholic Diocese of Timișoara and one of the city's landmarks. The cathedral is dedicated to St. George and was built between 1736 and 1774. After the Cathedral Basilica of Oradea, it is the second largest Baroque religious building in Southeastern Europe. Liturgies in Hungarian, German and Romanian are currently held regularly in the cathedral. Due to the remarkable acoustics, organ concerts are also held here. ",
                21.229922,
                45.758166,
                photoUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d6/Temi%C5%A1var%2C_Rumunija_37.jpg/440px-Temi%C5%A1var%2C_Rumunija_37.jpg"
            ),
            LocationDto("12345675",
            "Serbian Church",
                "The Ascension Cathedral, commonly known as the Serbian Orthodox Cathedral, is the cathedral of the Serbian Orthodox Eparchy of Timișoara. Located in the Union Square of Cetate district, the building is one of the three Serbian Orthodox churches in the city together with the St. George Church in Fabric district and the St. Nicholas Church in the Avram Iancu Square of Mehala district.",
                21.228141,
                45.757960,
                photoUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Pia%C5%A3a_Unirii_-_panoramio_%286%29.jpg/440px-Pia%C5%A3a_Unirii_-_panoramio_%286%29.jpg"
            ),
            LocationDto("12345674",
            "Iosefin Water Tower",
            "The Iosefin Water Tower is an industrial monument in Timișoara, Romania. It was one of the sources of water supply in Timișoara at the beginning of the 20th century. It is classified as a national heritage site. The Iosefin Water Tower was built between December 1912 and September 1913 by the Budapest company of János Lenarduzzi, as part of the drinking water distribution network of Timișoara, which also included its twin water tower in Fabric.",
                21.201899,
                45.745479,
                photoUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Water_tower_in_Iosefin.jpg/440px-Water_tower_in_Iosefin.jpg"
            ),
            LocationDto("12345673",
            "Huniade Castle",
            "The Huniade Castle is the oldest monument in Timișoara, Romania, built between 1443 and 1447 by John Hunyadi and Paolo Santini de Duccio over the old royal castle dating from the 14th century (built during the reign of Charles I Robert). The castle was rebuilt by the Turkish pashas in the 17th century and by Prince Eugene of Savoy in the 18th century. The structure owes its present appearance to the 1850s reconstruction campaign. It houses the History, Archeology and Natural Sciences sections of the National Museum of Banat.",
                21.227109,
                45.753464,
            photoUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Castelul_Huniazilor.jpg/440px-Castelul_Huniazilor.jpg")
        )
    }
}