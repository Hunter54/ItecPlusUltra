package com.example.timieu2023.features.home.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeTabRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
){
    HomeTabScreen()
}

@Composable
    fun HomeTabScreen(
    modifier: Modifier = Modifier
){
        Text(text = "Home")
    }