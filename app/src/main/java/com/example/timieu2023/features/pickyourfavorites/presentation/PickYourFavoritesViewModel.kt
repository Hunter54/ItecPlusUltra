package com.example.timieu2023.features.pickyourfavorites.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timieu2023.datastore.DatastoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject

@HiltViewModel
class PickYourFavoritesViewModel @Inject constructor(
    val datastoreRepository: DatastoreRepository
) : ViewModel() {

    var filteredFavorites = mutableListOf<String>()

    fun addDataToDataStore() {
        viewModelScope.launch {
            val serializedList = Json.encodeToString(filteredFavorites)
            datastoreRepository.write("serializedList", serializedList)
        }
    }

}