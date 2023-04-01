package com.example.timieu2023.features.scanner

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ApiState
import com.example.timieu2023.features.scanner.data.LocationEntity
import com.example.timieu2023.features.scanner.data.LocationsRepository
import com.example.timieu2023.features.scanner.presentation.VisitedLocationItem
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScannerViewModel @Inject constructor(private val locationsRepository: LocationsRepository) :
    ViewModel() {

    init {
//        viewModelScope.launch {
//            locationsRepository.fetchLocations()
//        }
    }

    private val _scannerScreenState = MutableStateFlow<ScannerScreenState>(ScannerScreenState.Default)
    val scannerScreenState = _scannerScreenState.asStateFlow()

    val visitedLocations = locationsRepository.visitedLocations.map { locationList ->
        locationList.map {
            VisitedLocationItem(it.id, it.locationName, it.locationDescription, it.photoUrl)
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000), listOf()
    )

    fun resetScannerScreenState(){
        _scannerScreenState.update { ScannerScreenState.Default }
    }

    val options = GmsBarcodeScannerOptions.Builder()
        .setBarcodeFormats(
            Barcode.FORMAT_QR_CODE,
            Barcode.FORMAT_AZTEC
        )
        .build()

    fun addVisitedLocation(locationId: String) {
        viewModelScope.launch {
            _scannerScreenState.update { ScannerScreenState.Loading }
            when(val result  = locationsRepository.addVisitedLocation(locationId)){
                is ApiState.Failed ->_scannerScreenState.update{ScannerScreenState.Error(result.message)}
                is ApiState.Success -> {
                    with(result.data){
                        _scannerScreenState.update {ScannerScreenState.Success(VisitedLocationItem(this.id,this.locationName,this.locationDescription, this.photoUrl))}
                    }
                }
            }
        }
    }

}

sealed interface ScannerScreenState {
    object Default: ScannerScreenState
    object Loading: ScannerScreenState
    data class Success(val location: VisitedLocationItem): ScannerScreenState
    data class Error(@StringRes val string: Int): ScannerScreenState
}