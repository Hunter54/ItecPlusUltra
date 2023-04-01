package com.example.timieu2023.features.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.timieu2023.features.home.domain.EventViewData
import com.example.timieu2023.features.home.presentation.weather.WeatherCard
import com.example.timieu2023.features.home.presentation.weather.WeatherState

@Composable
fun HomeTabRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val homeState by viewModel.state.collectAsState()
    val events by viewModel.events.collectAsState()

    HomeTabScreen(
        onQueryChange = { query ->
            viewModel.onSearchQueryChange(query)
        },
        homeState.query,
        weatherState = homeState.weatherState,
        events = events,
        modifier,
    )
}

@Composable
fun HomeTabScreen(
    onQueryChange: (String) -> Unit,
    query: String,
    weatherState: WeatherState,
    events: List<EventViewData>,
    modifier: Modifier = Modifier
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
            events = events
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
        text = "All Events",
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(start = 16.dp, top = 4.dp, bottom = 4.dp)
    )
}

@Composable
fun DestinationsTab(
    modifier: Modifier = Modifier,
    events: List<EventViewData>,
) {
    BoxWithConstraints(
        modifier = modifier.height(500.dp),
    ) {
        LazyColumn {
            items(events) { destination ->
                EventItem(destination)
            }
        }
    }
}

@Composable
fun EventItem(
    event: EventViewData,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
            .padding(top = 12.dp, start = 16.dp, end = 16.dp)
            .height(140.dp)
            .fillMaxWidth(),

        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxHeight()
        ) {
            AsyncImage(
                modifier = modifier
                    .width(100.dp)
                    .padding(start = 16.dp)
                    .border(
                        width = 3.dp, brush = Brush.horizontalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.tertiary,
                                MaterialTheme.colorScheme.secondary
                            )
                        ),
                        shape = RoundedCornerShape(5.dp)
                    ),
                model = event.imageRef,
                contentDescription = null,
                alignment = Alignment.CenterStart
            )
            Column {
                Text(
                    text = event.eventName.toString(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    modifier = modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp)
                )
                Row {
                    Text(
                        text = event.eventDate.toString(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        modifier = modifier.padding(start = 16.dp)
                    )
                    Text(
                        text = event.eventTime.toString(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        modifier = modifier.padding(end = 8.dp)
                    )
                }
                Text(
                    text = event.eventNameLocation.toString(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start,
                    modifier = modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 4.dp,
                        bottom = 8.dp
                    )
                )
            }
        }
    }
}



