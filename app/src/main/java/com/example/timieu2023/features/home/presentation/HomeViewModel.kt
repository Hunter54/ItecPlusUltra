package com.example.timieu2023.features.home.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

): ViewModel() {

    private val _state = MutableStateFlow<HomeViewState>(HomeViewState(query = "Search destination"))
    val state: StateFlow<HomeViewState> = _state

    fun onSearchQueryChange(changedQuery: String) {
        _state.update {
            it.copy(query = changedQuery)
        }
    }

}

data class HomeViewState(
//    val listAllEvent: List<HomeViewData> = emptyList(),
//    val isNetworkAvailable: Boolean? = null,
    val query: String
)