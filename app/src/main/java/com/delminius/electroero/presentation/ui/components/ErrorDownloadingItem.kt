package com.delminius.electroero.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.delminius.electroero.R
import com.delminius.electroero.presentation.ui.theme.IMAGE_ITEM_SIZE
import com.delminius.electroero.presentation.ui.theme.NORMAL_PADDING

@Composable
fun ErrorDownloadingComponent(
    errorMessage: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = NORMAL_PADDING),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_error),
            contentDescription = "Error icon",
            tint = MaterialTheme.colors.secondary,
            modifier = Modifier.size(IMAGE_ITEM_SIZE)
        )
        Text(
            text = errorMessage,
            style = MaterialTheme.typography.h6.copy(textAlign = TextAlign.Center)
        )
    }
}