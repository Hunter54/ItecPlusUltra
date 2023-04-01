package com.example.timieu2023.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timieu2023.datastore.DatastoreRepository
import com.example.timieu2023.features.home.domain.DestinationViewData
import com.example.timieu2023.features.home.domain.Resource
import com.example.timieu2023.features.home.domain.WeatherRepository
import com.example.timieu2023.features.home.presentation.weather.WeatherState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val datastoreRepository: DatastoreRepository
) : ViewModel() {

    private val _state =
        MutableStateFlow<HomeViewState>(HomeViewState(query = "Search destination"))
    val state: StateFlow<HomeViewState> = _state

    init {
        loadWeatherInfo()
        _state.update {
            it.copy(
                destinations = listOf(
                    DestinationViewData(),
                    DestinationViewData(),
                    DestinationViewData(),
                    DestinationViewData(),
                )
            )
        }
        viewModelScope.launch {
            datastoreRepository.read("serializedList").debounce(500).collect { result ->
                val deserializedList = Json.decodeFromString<List<String>>(result)
                println("cata $deserializedList")
            }
        }
    }

    fun onSearchQueryChange(changedQuery: String) {
        _state.update {
            it.copy(query = changedQuery)
        }
    }

    fun loadWeatherInfo() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    weatherState = WeatherState(
                        weatherInfo = null,
                        isLoading = false,
                        error = null
                    )
                )
            }
            when (val result = weatherRepository.getWeatherData()) {
                is Resource.Success -> {
                    _state.update {
                        it.copy(
                            weatherState = WeatherState(
                                weatherInfo = result.data,
                                isLoading = false,
                                error = null
                            )
                        )
                    }
                }
                is Resource.Error -> {
                    _state.update {
                        it.copy(
                            weatherState = WeatherState(
                                weatherInfo = null,
                                isLoading = false,
                                error = result.message
                            )
                        )
                    }
                }
            }
        }
    }
}

data class HomeViewState(
//    val listAllEvent: List<HomeViewData> = emptyList(),
//    val isNetworkAvailable: Boolean? = null,
    val query: String,
    val weatherState: WeatherState = WeatherState(
        weatherInfo = null, isLoading = false, error = null
    ),
    val destinations: List<DestinationViewData> = emptyList()
)