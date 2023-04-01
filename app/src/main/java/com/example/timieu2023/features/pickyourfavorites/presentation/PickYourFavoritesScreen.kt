package com.example.timieu2023.features.pickyourfavorites.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timieu2023.R
import com.example.timieu2023.ui.theme.TimiEu2023Theme
import com.example.timieu2023.ui.theme.seed

@Composable
fun PickYourFavoritesScreen() {
    TimiEu2023Theme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = stringResource(id = R.string.pick_your_favorites),
                modifier = Modifier.padding(top = 60.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview
@Composable
fun PickYourFavoriesScreenPreview() {
    TimiEu2023Theme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            PickYourFavoritesScreen()
        }
    }
}