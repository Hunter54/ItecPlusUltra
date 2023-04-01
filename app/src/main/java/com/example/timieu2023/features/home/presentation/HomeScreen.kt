package com.example.timieu2023.features.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timieu2023.features.home.presentation.weather.WeatherCard
import com.example.timieu2023.features.home.presentation.weather.WeatherState

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
        modifier,
    )
}

@Composable
fun HomeTabScreen(
    onQueryChange: (String) -> Unit,
    query: String,
    weatherState: WeatherState,
    modifier: Modifier = Modifier
) {

    Column {
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
        Row() {
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

//        WeatherForecast(state = weatherState)
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
        modifier = modifier.padding(start = 16.dp, top = 4.dp, bottom = 4.dp)
    )
}



