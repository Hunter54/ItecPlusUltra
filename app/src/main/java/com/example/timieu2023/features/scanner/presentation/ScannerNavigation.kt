package com.example.timieu2023.features.scanner.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.timieu2023.BottomNavigationItem

fun NavController.navigateToScannerTab(navOptions: NavOptions? = null) {
    this.navigate(BottomNavigationItem.Scanner.route, navOptions)
}

fun NavGraphBuilder.scannerTabScreen() {
    composable(route = BottomNavigationItem.Scanner.route) {
        ScannerRoute()
    }
}