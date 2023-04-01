package com.example.timieu2023.features.scanner.presentation

import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.timieu2023.R
import com.example.timieu2023.features.scanner.ScannerViewModel
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning

@Composable
fun ScannerRoute(
    modifier: Modifier = Modifier,
    viewModel: ScannerViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val scanner = remember {
        GmsBarcodeScanning.getClient(context, viewModel.options)
    }
    ScannerScreen(onScanPressed = {
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
    })
}

@Composable
fun ScannerScreen(onScanPressed: () -> Unit, modifier: Modifier = Modifier) {


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(modifier = Modifier.padding(bottom = 40.dp),onClick = onScanPressed) {
            Row(modifier = Modifier.padding(10.dp),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)){
                Icon(
                    painter = painterResource(id = R.drawable.qr_code_scanner_24),
                    contentDescription = null
                )
                Text(text = stringResource(id = R.string.scan_qr_button))
            }

        }
    }
}

