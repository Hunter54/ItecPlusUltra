package com.example.timieu2023.features.eventsmap

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class EventsMapViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    stringDecoder: StringDecoder,
): ViewModel() {

    private val eventArgs: EventArgs = EventArgs(savedStateHandle, stringDecoder)
    val latId = eventArgs.lat
    val longId = eventArgs.long

    private val _eventsUiState = MutableStateFlow<EventDetailsUiState>(EventDetailsUiState())
    val eventsUiState: StateFlow<EventDetailsUiState> = _eventsUiState

    init {
        _eventsUiState.update {
            it.copy(
                lat = latId.toDouble(),
                long = longId.toDouble()
            )
        }
    }
}


data class EventDetailsUiState(
    val lat: Double = 20.00,
    val long: Double = 20.00
)