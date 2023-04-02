package com.example.timieu2023

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

sealed class BottomNavigationItem(
    val route: String,
    @DrawableRes var icon: Int,
    @StringRes var title: Int
) {

    object Home :
        BottomNavigationItem(
            "home",
            R.drawable.baseline_home_24,
            R.string.home
        )

    object Map :
        BottomNavigationItem(
            "map",
            R.drawable.baseline_map_24,
            R.string.map
        )

    object Scanner :
        BottomNavigationItem(
            "hunt",
            R.drawable.baseline_explore_24,
            R.string.scanner
        )

    object EventsMap :
        BottomNavigationItem(
            "eventsmap",
            R.drawable.baseline_explore_24,
            R.string.scanner
        )
}