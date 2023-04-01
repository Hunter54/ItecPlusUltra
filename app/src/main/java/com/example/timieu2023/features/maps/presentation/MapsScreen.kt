package com.example.timieu2023.features.maps.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timieu2023.features.scanner.data.LocationEntity
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapsTabRoute(
    modifier: Modifier = Modifier,
    viewModel: MapsViewModel = hiltViewModel()
){
    val locations by viewModel.locations.collectAsState()



    MapsTabScreen(
        locations
    )
}

@Composable
fun MapsTabScreen(
    locations: List<LocationEntity>,
    modifier: Modifier = Modifier
){
    val timisoara = LatLng(45.75, 21.23)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(timisoara, 12.5f)
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
        locations.forEach {
            Marker(
                state = MarkerState(position = LatLng(
                    it.locationLatitude, it.locationLongitude
                )),
                title = it.locationName,
                snippet = ""
            )
        }
    }
}

