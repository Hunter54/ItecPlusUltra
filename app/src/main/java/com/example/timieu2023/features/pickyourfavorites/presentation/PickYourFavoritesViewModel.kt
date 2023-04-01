package com.example.timieu2023.features.pickyourfavorites.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timieu2023.datastore.DatastoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PickYourFavoritesViewModel @Inject constructor(
    datastoreRepository: DatastoreRepository
) : ViewModel() {



    init {
        viewModelScope.launch {
            datastoreRepository.write("test", "citire din datastore")
        }
        viewModelScope.launch {
            datastoreRepository.read("test").collect{ result ->
                println("cata $result")
            }
        }
    }
}