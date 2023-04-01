package com.example.timieu2023

import android.app.Application
import com.example.timieu2023.datastore.DatastoreRepository
import com.example.timieu2023.features.scanner.data.LocationsRepository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class App: Application() {

    @Inject
    lateinit var datastoreRepository: DatastoreRepository

    @Inject
    lateinit var locationsRepository: LocationsRepository

    @Inject
    lateinit var applicationScope: CoroutineScope

    override fun onCreate() {
        super.onCreate()
        applicationScope.launch {
//            locationsRepository.fetchLocations()
            datastoreRepository.read("FirstTime").collect{
                if(it.isEmpty()){
                    locationsRepository.fetchLocations()
                    datastoreRepository.write("FirstTime", "True")
                }
            }
        }
    }
}