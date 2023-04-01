package com.example.timieu2023.features.scanner

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timieu2023.features.scanner.data.LocationsRepository
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScannerViewModel @Inject constructor(private val locationsRepository: LocationsRepository) :
    ViewModel() {

    init {
        viewModelScope.launch {
            locationsRepository.fetchLocations()
        }
    }

    val visitedLocations = locationsRepository.visitedLocations.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000), listOf()
    )

    val options = GmsBarcodeScannerOptions.Builder()
        .setBarcodeFormats(
            Barcode.FORMAT_QR_CODE,
            Barcode.FORMAT_AZTEC
        )
        .build()

    fun addVisitedLocation(locationId: String) {
        viewModelScope.launch { locationsRepository.addVisitedLocation(locationId) }
    }

}