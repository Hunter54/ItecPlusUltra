package com.example.timieu2023.features.eventsmap

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timieu2023.features.home.domain.EventViewData
import com.example.timieu2023.features.maps.presentation.MapsTabScreen
import com.example.timieu2023.features.maps.presentation.MapsViewModel
import com.example.timieu2023.features.scanner.data.LocationEntity
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun EventsMapsTabRoute(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    viewModel: EventsMapViewModel = hiltViewModel()
){
    val eventState by viewModel.eventsUiState.collectAsState()

    EventsMapScreen(
        eventState.lat,
        eventState.long
    )
}

@Composable
fun EventsMapScreen(
    lat: Double,
    long: Double,
    modifier: Modifier = Modifier
){
    val timisoara = LatLng(lat, long)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(timisoara, 15.5f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = timisoara),
            title = "Timisoara",
            snippet = "Downtown Timisoara"
        )
    }
}