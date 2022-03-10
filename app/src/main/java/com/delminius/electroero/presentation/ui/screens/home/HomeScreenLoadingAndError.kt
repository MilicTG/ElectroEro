package com.delminius.electroero.presentation.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.delminius.electroero.presentation.ui.components.DownloadingInProgress
import com.delminius.electroero.presentation.ui.components.ErrorDownloadingComponent
import com.delminius.electroero.presentation.ui.theme.BOTTOM_PADDING
import com.delminius.electroero.presentation.ui.theme.NORMAL_PADDING

@Composable
fun HomeScreenLoadingAndError(
    isLoading: Boolean,
    isError: Boolean,
    errorMessage: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                bottom = BOTTOM_PADDING,
                start = NORMAL_PADDING,
                end = NORMAL_PADDING
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        if (isLoading) {
            DownloadingInProgress()
        }
        if (isError) {
            ErrorDownloadingComponent(
                errorMessage = errorMessage
            )
        }
    }
}