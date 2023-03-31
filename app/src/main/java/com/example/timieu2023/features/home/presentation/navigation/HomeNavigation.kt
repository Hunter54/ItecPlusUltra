package com.example.timieu2023.features.home.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.timieu2023.BottomNavigationItem
import com.example.timieu2023.features.home.presentation.HomeTabRoute

fun NavController.navigateToHomeTabGraph(navOptions: NavOptions? = null) {
    this.navigate(BottomNavigationItem.Home.route, navOptions)
}

fun NavGraphBuilder.homeTabScreen() {
    composable(route = MapsDestinations.Events.route) {
        HomeTabRoute()
    }
}