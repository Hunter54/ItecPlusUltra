package com.example.timieu2023.features.onboarding.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.timieu2023.R
import com.example.timieu2023.ui.theme.seed

@Composable
fun OnboardingScreen(
    onButtonClicked: () -> Unit,
) {
    Box {
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .zIndex(0.2F)
        ){
            Button(
                modifier = Modifier
                    .width(250.dp)
                    .height(130.dp)
                    .padding(bottom = 60.dp),
                onClick = onButtonClicked,
                colors = ButtonDefaults.textButtonColors(
                    containerColor = seed,
                    contentColor = Color.White
                )
            ) {
                Text(text = stringResource(id = R.string.lets_start))
                Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = null)
            }
        }
        Box(
            modifier = Modifier.fillMaxSize()
        ){
            Image(
                painter = painterResource(id = R.drawable.onboarding_screen),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}