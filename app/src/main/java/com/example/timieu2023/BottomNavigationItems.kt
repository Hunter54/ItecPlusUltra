package com.example.timieu2023

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItem(
    val route: String,
    var icon: ImageVector,
    @StringRes var title: Int
) {

    object Home :
        BottomNavigationItem(
            "home",
            Icons.Default.Home,
            R.string.home
        )

    object Map :
        BottomNavigationItem(
            "map",
            Icons.Default.LocationOn,
            R.string.map
        )

    object Favourite :
        BottomNavigationItem(
            "favourite",
            Icons.Default.Favorite,
            R.string.favourite
        )

    object Account :
        BottomNavigationItem(
            "account",
            Icons.Default.AccountCircle,
            R.string.acount
        )
}