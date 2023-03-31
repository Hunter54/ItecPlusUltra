package com.example.timieu2023.features.maps.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MapsTabRoute(
    modifier: Modifier = Modifier,
    viewModel: MapsViewModel = hiltViewModel()
){
    MapsTabScreen()
}

@Composable
fun MapsTabScreen(
    modifier: Modifier = Modifier
){
    Text(text = "Maps")
}

