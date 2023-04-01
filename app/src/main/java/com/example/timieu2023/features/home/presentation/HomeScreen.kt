package com.example.timieu2023.features.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timieu2023.R

@Composable
fun HomeTabRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val homeState by viewModel.state.collectAsState()

    HomeTabScreen(
        onQueryChange = { query ->
            viewModel.onSearchQueryChange(query)
        },
        homeState.query,
        modifier
    )
}

@Composable
fun HomeTabScreen(
    onQueryChange: (String) -> Unit,
    query: String,
    modifier: Modifier = Modifier
) {

    Column {
        TopWelcomeTab(
            modifier
        )
        HomeSearchField(
            onSearch = {},
            onActiveChange = {},
            onQueryChange = onQueryChange,
            query = query,
            modifier = modifier
        )
        HomeTopQuestion(
            modifier
        )
    }
}

@Composable
fun TopWelcomeTab(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.mosulica), contentDescription = null,
            modifier.padding(start = 16.dp, top = 12.dp, end = 12.dp, bottom = 12.dp)
        )
        Text(text = "Welcome Back")
        Icon(
            imageVector = Icons.Filled.Favorite, contentDescription = null,
            modifier = modifier.padding(start = 4.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeSearchField(
    onSearch: (String) -> Unit,
    onActiveChange: (Boolean) -> Unit,
    onQueryChange: (String) -> Unit,
    query: String,
    modifier: Modifier = Modifier
) {
    SearchBar(
        query = query,
        onQueryChange = onQueryChange,
        onSearch = onSearch,
        active = false,
        onActiveChange = onActiveChange,
        enabled = true,
        trailingIcon = {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
        },
        tonalElevation = 16.dp,
        shape = RoundedCornerShape(16.dp),
        modifier = modifier.padding(start = 16.dp, end = 16.dp)
    ) {

    }
}

@Composable
fun HomeTopQuestion(
    modifier: Modifier = Modifier
) {
    Column(
        modifier.padding(start = 16.dp, top = 8.dp)
    ) {
        Text(
            text = "Where are you",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Row() {
            Text(
                text = "going",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "today",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = modifier.padding(start = 6.dp)
            )
            Text(
                text = "?",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}