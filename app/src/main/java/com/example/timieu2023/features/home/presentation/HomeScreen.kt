package com.example.timieu2023.features.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timieu2023.R

@Composable
fun HomeTabRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeTabScreen()
}

@Composable
fun HomeTabScreen(
    modifier: Modifier = Modifier
) {
    TopWelcomeTab(
        modifier
    )
}

@Composable
fun TopWelcomeTab(
    modifier: Modifier = Modifier
) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.mosulica), contentDescription = null,
            modifier.padding(16.dp)
        )
        Column {
            Row {
                Text(text = "Welcome Home")
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
            }
            Text("Sarah Good")
        }
    }
}