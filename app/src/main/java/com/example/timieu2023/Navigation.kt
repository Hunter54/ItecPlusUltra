package com.example.timieu2023

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import com.example.timieu2023.features.home.presentation.navigation.homeTabScreen
import com.example.timieu2023.features.home.presentation.navigation.MapsDestinations
import com.example.timieu2023.features.maps.presentation.navigation.mapsTabScreen

@Composable
fun MainNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    NavHost(navController = navController, startDestination = BottomNavigationItem.Home.route, modifier = modifier){
        homeGraph()
        mapsTabScreen()
    }

}

fun NavGraphBuilder.homeGraph(){
    navigation(
        route = BottomNavigationItem.Home.route,
        startDestination = MapsDestinations.Events.route
    ) {
        homeTabScreen()
    }
}