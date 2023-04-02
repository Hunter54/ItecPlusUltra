package com.example.timieu2023.features.scanner.presentation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.timieu2023.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationBottomSheet(
    locationItem: VisitedLocationItem,
    sheetState: SheetState,
    onDismissRequest: () -> Unit
) {
    val scrollState = rememberScrollState()
    ModalBottomSheet(modifier = Modifier.offset(y = 20.dp),sheetState = sheetState, onDismissRequest = { onDismissRequest() }) {
        Column(
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, bottom = 10.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = locationItem.name, style = MaterialTheme.typography.headlineMedium)
            SubcomposeAsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 300.dp)
                    .padding(vertical = 20.dp)
                    .border(
                        width = 3.dp, brush = Brush.horizontalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.tertiary,
                                MaterialTheme.colorScheme.secondary
                            )
                        ),
                        shape = RoundedCornerShape(5.dp)
                    ),
                model = locationItem.photoUrl,
                contentDescription = stringResource(id = R.string.location_image_description),
                loading = {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) { CircularProgressIndicator() }
                },
                error = {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_broken_image_24),
                        contentDescription = stringResource(
                            id = R.string.failed_to_load_image_placeholder
                        )
                    )
                }
            )
            Text(modifier = Modifier.fillMaxWidth(), text = locationItem.description)
            Button(modifier = Modifier.padding(vertical = 40.dp), onClick = onDismissRequest) {
                Row(
                    modifier = Modifier.padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(text = stringResource(id = R.string.button_close))
                }

            }
        }

    }
}