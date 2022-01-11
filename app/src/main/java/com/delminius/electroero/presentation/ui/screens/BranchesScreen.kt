package com.delminius.electroero.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.delminius.electroero.R
import com.delminius.electroero.presentation.ui.components.TopAppHeader

@Composable
fun BranchesScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        TopAppHeader(
            headerTitle = stringResource(R.string.branches),
            headerSubtitle = stringResource(R.string.all_branches),
            onInfoButtonClicked = {}
        )
    }
}