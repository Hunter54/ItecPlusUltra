package com.example.timieu2023

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.timieu2023.features.onboarding.presentation.OnboardingScreen
import com.example.timieu2023.features.pickyourfavorites.presentation.PickYourFavoritesScreen
import com.example.timieu2023.ui.theme.TimiEu2023Theme
import kotlinx.coroutines.delay
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private var keepSplashOpened = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition{ keepSplashOpened }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
            installSplashScreen()
        }
        setContent {
            TimiEu2023Theme {
                SplashScreen(
                    onDataLoaded = {
                        keepSplashOpened = false
                    }
                )
            }
        }
    }
}

@Composable
fun SplashScreen(onDataLoaded: () -> Unit) {
    var fakeLoading by remember { mutableStateOf(true) }
    var showMainScreen by remember { mutableStateOf(false) }
    var pickYourFavoritesScreen by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        fakeLoading = false
        onDataLoaded()
    }

    if(!fakeLoading) {
        if(pickYourFavoritesScreen) {
            PickYourFavoritesScreen(
                onContinueButtonClicked = {
                    showMainScreen = true
                }
            )
        } else {
            OnboardingScreen(
                onButtonClicked = {
                    pickYourFavoritesScreen = true
                }
            )
        }
    }
    if(showMainScreen) {
        MainScreen()
    }
}
         
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainScreen(
    appState: AppState = rememberAppState(),
) {

    val navController = appState.navController
    Scaffold(bottomBar = {
        BrivoAccessBottomNavigation(navController,
        onNavigateToDestination = { destination ->
            navigateToTopLevelDestination(navController, destination)
        })
    }) {paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .consumeWindowInsets(paddingValues)
        ) {
            MainNavigation(
                navController = navController
            )
        }
    }
}