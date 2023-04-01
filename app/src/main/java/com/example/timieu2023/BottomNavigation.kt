package com.example.timieu2023

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import com.example.timieu2023.features.home.presentation.navigation.navigateToHomeTabGraph
import com.example.timieu2023.features.maps.presentation.navigation.navigateToMapsGraph
import com.example.timieu2023.features.scanner.presentation.navigateToScannerTab

@Composable
fun BrivoAccessBottomNavigation(
    navController: NavController,
    onNavigateToDestination: (BottomNavigationItem) -> Unit
) {

    val destinations = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Map,
        BottomNavigationItem.Scanner
    )

    NavigationBar(modifier = Modifier) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination

        destinations.forEach { destination ->
            val selected = currentRoute.isTopLevelDestinationInHierarchy(destination)
            NavigationBarItem(
                selected = selected, onClick = { onNavigateToDestination(destination) },

                icon = {
                    Icon(painterResource(id = destination.icon), contentDescription = null)
                },
                label = {
                    Text(text = stringResource(id = destination.title))
                },
                alwaysShowLabel = true
            )
        }
    }
}

fun navigateToTopLevelDestination(
    navController: NavController,
    topLevelDestination: BottomNavigationItem
) {
    val topLevelNavOptions = navOptions {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }

    when (topLevelDestination) {
        BottomNavigationItem.Home -> navController.navigateToHomeTabGraph(topLevelNavOptions)
//        BottomNavigationItem.Account -> navController.navigateAccount(topLevelNavOptions)
        BottomNavigationItem.Map -> navController.navigateToMapsGraph(topLevelNavOptions)
        BottomNavigationItem.Scanner -> navController.navigateToScannerTab(topLevelNavOptions)
        else -> {
            navController.navigateToMapsGraph(topLevelNavOptions)
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: BottomNavigationItem) =
    this?.hierarchy?.any {
        it.route?.contains(destination.route, true) ?: false
    } ?: false