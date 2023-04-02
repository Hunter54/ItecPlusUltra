package com.example.timieu2023.features.maps.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.timieu2023.BottomNavigationItem
import com.example.timieu2023.features.maps.presentation.MapsTabRoute

fun NavController.navigateToMapsGraph(navOptions: NavOptions? = null) {
    this.navigate(BottomNavigationItem.Map.route, navOptions)
}

fun NavGraphBuilder.mapsTabScreen() {
    composable(route = BottomNavigationItem.Map.route) {
        MapsTabRoute()
    }
}