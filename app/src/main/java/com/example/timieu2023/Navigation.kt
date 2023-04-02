package com.example.timieu2023

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import com.example.timieu2023.features.eventsmap.EventDetailsArguments
import com.example.timieu2023.features.eventsmap.eventsmapTabScreen
import com.example.timieu2023.features.eventsmap.navigateToEventDetails
import com.example.timieu2023.features.home.domain.EventViewData
import com.example.timieu2023.features.home.presentation.navigation.homeTabScreen
import com.example.timieu2023.features.maps.presentation.navigation.HomeDestinations
import com.example.timieu2023.features.maps.presentation.navigation.mapsTabScreen
import com.example.timieu2023.features.scanner.presentation.scannerTabScreen

@Composable
fun MainNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigationItem.Home.route,
        modifier = modifier
    ) {
        homeGraph(
            onEventClicked = {
                navController.navigateToEventDetails(
                    it.latId,
                    it.longId
                )
            },
            nestedGraph = {
                eventsmapTabScreen(onBackClick = { navController.navigateUp() })
            }
        )
        mapsTabScreen()
        scannerTabScreen()
    }
}

fun NavGraphBuilder.homeGraph(
    onEventClicked: (EventDetailsArguments) -> Unit,
    nestedGraph: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = BottomNavigationItem.Home.route,
        startDestination = HomeDestinations.Events.route
    ) {
        homeTabScreen(onEventClicked)
        nestedGraph()
    }
}