package com.example.timieu2023.features.scanner.presentation

import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.timieu2023.R
import com.example.timieu2023.features.scanner.ScannerScreenState
import com.example.timieu2023.features.scanner.ScannerViewModel
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import kotlinx.coroutines.launch

@Composable
fun ScannerRoute(
    modifier: Modifier = Modifier,
    viewModel: ScannerViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val scanner = remember {
        GmsBarcodeScanning.getClient(context, viewModel.options)
    }
    val scannerScreenState by viewModel.scannerScreenState.collectAsState()
    val visitedLocations by viewModel.visitedLocations.collectAsState()
    ScannerScreen(
        scannerScreenState = scannerScreenState,
        visitedLocations = visitedLocations,
        resetScreenState = {
            viewModel.resetScannerScreenState()
        },
        onScanPressed = {
            scanner.startScan()
                .addOnSuccessListener { barcode ->
                    barcode.displayValue?.let { viewModel.addVisitedLocation(it) }
                }
                .addOnCanceledListener {
                    // Task canceled
                }
                .addOnFailureListener { e ->
                    // Task failed with an exception
                }
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScannerScreen(
    visitedLocations: List<VisitedLocationItem>,
    scannerScreenState: ScannerScreenState,
    onScanPressed: () -> Unit,
    resetScreenState: () -> Unit,
    modifier: Modifier = Modifier
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var openBottomSheet by rememberSaveable { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    var selectedLocation by remember { mutableStateOf(visitedLocations.firstOrNull()) }
    val context = LocalContext.current
    LaunchedEffect(key1 = scannerScreenState) {
        if (scannerScreenState is ScannerScreenState.Success) {
            selectedLocation = scannerScreenState.location
            coroutineScope.launch {
                openBottomSheet = true
                sheetState.expand()
            }
            resetScreenState()
        }
    }

    when (scannerScreenState) {
        is ScannerScreenState.Error -> {
            Toast.makeText(
                context,
                stringResource(id = R.string.failed_to_verify_location),
                Toast.LENGTH_LONG
            ).show()
            resetScreenState()
        }
        else -> {}
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = stringResource(id = R.string.locations_title),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            items(visitedLocations) { location ->
                VisitedLocationItem(item = location, onClick = {
                    selectedLocation = location
                    coroutineScope.launch {
                        openBottomSheet = true
                        sheetState.expand()
                    }
                })
            }

        }
        if (visitedLocations.isEmpty()) {
            Column(
                modifier
                    .fillMaxSize()
                    .weight(10f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(stringResource(id = R.string.locations_nothing_visited))
            }
        }
        Button(modifier = Modifier.padding(bottom = 40.dp), onClick = onScanPressed) {
            Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.qr_code_scanner_24),
                    contentDescription = null
                )
                Text(text = stringResource(id = R.string.scan_qr_button))
            }

        }
    }
    if (openBottomSheet) {
        selectedLocation?.let {
            LocationBottomSheet(sheetState = sheetState, locationItem = it) {
                coroutineScope.launch {
                    sheetState.hide()
                }.invokeOnCompletion {
                    if (!sheetState.isVisible) {
                        openBottomSheet = false
                    }
                }
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisitedLocationItem(
    item: VisitedLocationItem,
    onClick: (VisitedLocationItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
        .height(IntrinsicSize.Min), onClick = { onClick(item) }) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            SubcomposeAsyncImage(model = item.photoUrl, contentDescription = null,
                modifier = Modifier
                    .size(80.dp), contentScale = ContentScale.FillBounds, loading = {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) { CircularProgressIndicator() }
                }, error = {
                    Column(
                        modifier = Modifier.height(100.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            modifier = Modifier.fillMaxHeight(),
                            painter = painterResource(id = R.drawable.baseline_broken_image_24),
                            contentDescription = stringResource(
                                id = R.string.failed_to_load_image_placeholder
                            ), contentScale = ContentScale.FillBounds
                        )
                    }
                })

            Column(
                modifier = modifier
                    .padding(horizontal = 10.dp)
                    .weight(1f)
            ) {
                Text(
                    text = item.name,
                    fontSize = 18.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = item.description,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewVisitedLocationItem() {
    VisitedLocationItem(
        VisitedLocationItem(
            "123", "Bastion Maria Theresa", "Old town with lots to see and discover everywhere",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Bastionul_Theresia_ansamblu.jpg/440px-Bastionul_Theresia_ansamblu.jpg"
        ), {}
    )
}

