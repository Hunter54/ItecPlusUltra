package com.example.timieu2023.features.maps.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timieu2023.features.scanner.data.LocationsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    val locationsRepository: LocationsRepository
) : ViewModel() {

    val locations = locationsRepository.allLocations
        .stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(5000L),
            listOf()
        )


}