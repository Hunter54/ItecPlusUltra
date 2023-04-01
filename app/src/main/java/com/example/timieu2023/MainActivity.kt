package com.example.timieu2023

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
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
            val splashScreen = installSplashScreen()
            splashScreen.setKeepOnScreenCondition { false }
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
    
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        fakeLoading = false
        onDataLoaded()
    }

    if(!fakeLoading) {
        MainScreen("Android")
    }
}
         
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainScreen(name: String, appState: AppState = rememberAppState()) {
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