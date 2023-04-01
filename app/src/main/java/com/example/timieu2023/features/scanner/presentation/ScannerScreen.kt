package com.example.timieu2023.features.scanner.presentation

import android.widget.Toast
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timieu2023.features.scanner.ScannerViewModel
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning

@Composable
fun ScannerRoute(
    modifier: Modifier = Modifier,
    viewModel: ScannerViewModel = hiltViewModel()
) {
    ScannerScreen(viewModel.options)
}

@Composable
fun ScannerScreen(scannerOptions: GmsBarcodeScannerOptions, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val scanner = remember {
        GmsBarcodeScanning.getClient(context, scannerOptions)
    }

    scanner.startScan()
        .addOnSuccessListener { barcode ->

            Toast.makeText(context, barcode.displayValue, Toast.LENGTH_LONG).show()
        }
        .addOnCanceledListener {
            // Task canceled
        }
        .addOnFailureListener { e ->
            // Task failed with an exception
        }

    Text(text = "Scanner")
}
