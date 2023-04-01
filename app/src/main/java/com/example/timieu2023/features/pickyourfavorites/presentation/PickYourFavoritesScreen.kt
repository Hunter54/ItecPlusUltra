@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.timieu2023.features.pickyourfavorites.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timieu2023.R
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timieu2023.ui.theme.TimiEu2023Theme

var favoritesMap: MutableMap<String, Boolean> = mutableMapOf(
    "Art" to false,
    "Sport" to false,
    "Innovation" to false,
    "Theatre" to false,
    "History" to false,
    "Science Fiction" to false
)

val filteredFavorites = mutableStateListOf<String>()

@Composable
fun PickYourFavoritesScreen(
    onContinueButtonClicked: () -> Unit,
    pickYourFavoritesViewModel: PickYourFavoritesViewModel = hiltViewModel()
) {
    TimiEu2023Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
           BoxWithConstraints(
               modifier = Modifier.fillMaxSize()
           ) {
                Column(
                    modifier = Modifier.padding(top = maxHeight / 5),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.pick_your_favorites),
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center,
                    )
                    Column(
                        modifier = Modifier.padding(top = 40.dp),
                    ) {
                        FirstRow()
                        SecondRow()
                        ThirdRow()
                    }
                    Box(
                        modifier = Modifier.padding(top = 100.dp)
                    ) {
                        Button(
                            modifier = Modifier
                                .width(250.dp)
                                .height(50.dp),
                            onClick = {
                                filterFavoritesSections()
                                pickYourFavoritesViewModel.filteredFavorites = filteredFavorites
                                pickYourFavoritesViewModel.addDataToDataStore()
                                onContinueButtonClicked()
                                filteredFavorites.clear()
                            },
                        ) {
                            Text(text = stringResource(id = R.string.continue_pick_your_favorites))
                            Icon(
                                imageVector = Icons.Filled.KeyboardArrowRight,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstRow() {

    var sportChip by remember { mutableStateOf(false) }
    var artChip by remember { mutableStateOf(false) }
    val sport = stringResource(id = R.string.sport_chip)
    val art = stringResource(id = R.string.art_chip)

    Row(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(top = 60.dp, start = 5.dp)
        ) {
            FilterChip(
                modifier = Modifier
                    .height(50.dp)
                    .width(200.dp),
                selected = sportChip,
                onClick = { sportChip = !sportChip },
                label = {
                    Text(
                        text = sport,
                        maxLines = 1,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                },
                shape = RoundedCornerShape(20.dp),
            )
        }
        Row {
            FilterChip(
                modifier = Modifier
                    .height(50.dp)
                    .width(200.dp),
                selected = artChip,
                onClick = { artChip = !artChip },
                label = {
                    Text(
                        text = art,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                },
                shape = RoundedCornerShape(20.dp)
            )
        }
    }
    favoritesMap[sport] = sportChip
    favoritesMap[art] = artChip
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondRow() {
    var theatreChip by remember { mutableStateOf(false) }
    var innovationChip by remember { mutableStateOf(false) }
    val theatre = stringResource(id = R.string.theatre_chip)
    val innovation = stringResource(id = R.string.innovation_chip)

    Row(
        modifier = Modifier.padding(start = 10.dp, end = 10.dp)
    ) {
        Row(
            modifier = Modifier.padding(top = 60.dp)
        ) {
            FilterChip(
                modifier = Modifier
                    .height(50.dp)
                    .width(200.dp),
                selected = theatreChip,
                onClick = { theatreChip = !theatreChip },
                label = {
                    Text(
                        text = theatre,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                },
                shape = RoundedCornerShape(20.dp)
            )
        }
        Row(
            modifier = Modifier.padding(top = 10.dp)
        ) {
            FilterChip(
                modifier = Modifier
                    .height(50.dp)
                    .width(200.dp),
                selected = innovationChip,
                onClick = { innovationChip = !innovationChip },
                label = {
                    Text(
                        text = innovation,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                },
                shape = RoundedCornerShape(20.dp)
            )
        }
    }
    favoritesMap[theatre] = theatreChip
    favoritesMap[innovation] = innovationChip
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirdRow() {
    var scienceFictionChip by remember { mutableStateOf(false) }
    var historyChip by remember { mutableStateOf(false) }
    val scienceFiction = stringResource(id = R.string.science_fiction_chip)
    val history = stringResource(id = R.string.history_chip)

    Row(
        modifier = Modifier.padding(start = 20.dp, end = 25.dp)
    ) {
        Row(
            modifier = Modifier.padding(top = 60.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            FilterChip(
                modifier = Modifier
                    .height(50.dp)
                    .width(200.dp),
                selected = scienceFictionChip,
                onClick = { scienceFictionChip = !scienceFictionChip },
                label = {
                    Text(
                        text = scienceFiction,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                },
                shape = RoundedCornerShape(20.dp)
            )
        }
        Row(
            modifier = Modifier.padding(top = 10.dp)
        ) {
            FilterChip(
                modifier = Modifier
                    .height(50.dp)
                    .width(200.dp),
                selected = historyChip,
                onClick = { historyChip = !historyChip },
                label = {
                    Text(
                        text = history,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                },
                shape = RoundedCornerShape(20.dp)
            )
        }
    }
    favoritesMap[scienceFiction] = scienceFictionChip
    favoritesMap[history] = historyChip
}

private fun filterFavoritesSections() {
    for((key, value) in favoritesMap) {
        if(value) {
            filteredFavorites.add(key)
        }
    }
}