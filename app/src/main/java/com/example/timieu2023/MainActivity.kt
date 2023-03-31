package com.example.timieu2023

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.timieu2023.ui.theme.TimiEu2023Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimiEu2023Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen("Android")
                }
            }
        }
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TimiEu2023Theme {
        MainScreen("Android")
    }
}