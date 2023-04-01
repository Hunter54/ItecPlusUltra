package com.example.timieu2023.features.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timieu2023.features.home.domain.DestinationViewData
import com.example.timieu2023.features.home.presentation.weather.WeatherCard
import com.example.timieu2023.features.home.presentation.weather.WeatherState
import com.example.timieu2023.features.pickyourfavorites.presentation.PickYourFavoritesViewModel

@Composable
fun HomeTabRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val homeState by viewModel.state.collectAsState()

    HomeTabScreen(
        onQueryChange = { query ->
            viewModel.onSearchQueryChange(query)
        },
        homeState.query,
        weatherState = homeState.weatherState,
        destinations = homeState.destinations,
        modifier,
    )
}

@Composable
fun HomeTabScreen(
    onQueryChange: (String) -> Unit,
    query: String,
    weatherState: WeatherState,
    destinations: List<DestinationViewData>,
    modifier: Modifier = Modifier,
    pickYourFavoritesViewModel: PickYourFavoritesViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
    ) {
        HomeSearchField(
            onSearch = {},
            onActiveChange = {},
            onQueryChange = onQueryChange,
            query = query,
            modifier = modifier
        )
        HomeTopQuestion(
            modifier
        )
        HomeFilterChips(
            modifier
        )
        HomeWeatherTab(weatherState = weatherState)
        DestinationsTitle()
        DestinationsTab(
            destinations = destinations
        )
        Spacer(modifier = modifier.padding(bottom = 8.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeSearchField(
    onSearch: (String) -> Unit,
    onActiveChange: (Boolean) -> Unit,
    onQueryChange: (String) -> Unit,
    query: String,
    modifier: Modifier = Modifier
) {
    SearchBar(
        query = query,
        onQueryChange = onQueryChange,
        onSearch = onSearch,
        active = false,
        onActiveChange = onActiveChange,
        enabled = true,
        trailingIcon = {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
        },
        tonalElevation = 16.dp,
        shape = RoundedCornerShape(16.dp),
        modifier = modifier.padding(start = 16.dp, end = 16.dp, top = 6.dp)
    ) {

    }
}

@Composable
fun HomeTopQuestion(
    modifier: Modifier = Modifier
) {
    Column(
        modifier.padding(start = 16.dp, top = 8.dp)
    ) {
        Text(
            text = "Where are you",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Row {
            Text(
                text = "going",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "today",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = modifier.padding(start = 6.dp)
            )
            Text(
                text = "?",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
fun HomeFilterChips(
    modifier: Modifier = Modifier
) {
    Text(
        text = "Filter chips",
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun HomeWeatherTab(
    weatherState: WeatherState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        HomeWeatherTitle()
        WeatherCard(state = weatherState, backgroundColor = Color.White)
    }
}

@Composable
fun HomeWeatherTitle(
    modifier: Modifier = Modifier
) {
    Text(
        text = "Weather",
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(start = 16.dp, top = 4.dp)
    )
}

@Composable
fun DestinationsTitle(
    modifier: Modifier = Modifier
) {
    Text(
        text = "All Destination",
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(start = 16.dp, top = 4.dp, bottom = 4.dp)
    )
}

@Composable
fun DestinationsTab(
    modifier: Modifier = Modifier,
    destinations: List<DestinationViewData>,
) {
    LazyRow {
        items(destinations) { destination ->
            DestinationItem(destination)
        }
    }
}

@Composable
fun DestinationItem(
    destination: DestinationViewData,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = Icons.Filled.Place, contentDescription = null,
                modifier = modifier
                    .height(150.dp)
                    .width(100.dp)
                    .padding(top = 8.dp, bottom = 8.dp)
            )
            Text(
                text = "Borobudur Temple",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                modifier = modifier.padding(start = 16.dp, end = 16.dp)
            )
        }
    }
}


