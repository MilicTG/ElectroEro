package com.delminius.electroero.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.delminius.electroero.presentation.ui.theme.EXTRA_LARGE_PADDING
import com.delminius.electroero.presentation.ui.theme.NORMAL_PADDING
import com.delminius.electroero.presentation.ui.theme.SPINNER_DOWNLOADING_SIZE

@Composable
fun DownloadingInProgress() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = NORMAL_PADDING),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(SPINNER_DOWNLOADING_SIZE)
                .padding(bottom = EXTRA_LARGE_PADDING),
            color = MaterialTheme.colors.secondary
        )
        Text(
            text = "Preuzimanje molimo pričekajte.",
            style = MaterialTheme.typography.h6.copy(textAlign = TextAlign.Center)
        )
    }
}