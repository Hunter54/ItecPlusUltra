package com.example.timieu2023.features.eventsmap

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.timieu2023.features.maps.presentation.navigation.HomeDestinations

const val LatIdArg = "latId"
const val LongIdArg = "longId"

class EventArgs(val lat: String, val long: String) {
    constructor(savedStateHandle: SavedStateHandle, stringDecoder: StringDecoder) : this(
        stringDecoder.decodeString(
            checkNotNull(savedStateHandle[LatIdArg])
        ),
        stringDecoder.decodeString(checkNotNull(savedStateHandle[LongIdArg]))
    )
}

data class EventDetailsArguments(val latId: String, val longId: String)

fun NavController.navigateToEventDetails(lat: String, long: String) {
    this.navigate("${HomeDestinations.EventDetails.route}/$lat&$long")
}

fun NavGraphBuilder.eventsmapTabScreen(
    onBackClick: () -> Unit
) {
    composable(
        route = "${HomeDestinations.EventDetails.route}/{$LatIdArg}&{${LongIdArg}}",
        arguments = listOf(
            navArgument(LatIdArg) { type = NavType.StringType },
            navArgument(LongIdArg) { type = NavType.StringType }
        ),
    ) {
        EventsMapsTabRoute(onBackClick = onBackClick)
    }
}