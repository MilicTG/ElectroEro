package com.delminius.electroero.presentation.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.delminius.electroero.R
import com.delminius.electroero.presentation.ui.components.DownloadingInProgress
import com.delminius.electroero.presentation.ui.components.ErrorDownloadingComponent
import com.delminius.electroero.presentation.ui.components.TopAppHeader
import com.delminius.electroero.util.Resource

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val powerCut = homeViewModel.currentPowerCutDayList.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        TopAppHeader(
            headerTitle = stringResource(R.string.welcome),
            headerSubtitle = stringResource(R.string.home_subtitle),
            onInfoButtonClicked = {}
        )

        Text(text = homeViewModel.formatToday.toString())
        Text(text = homeViewModel.tomorrow.toString())
        Text(text = homeViewModel.dayThree.toString())

        when (powerCut.value) {
            is Resource.Loading -> {
                DownloadingInProgress()
            }
            is Resource.Success -> {
                Text(text = powerCut.value.data!!.toString())
            }
            is Resource.Error -> {
                ErrorDownloadingComponent(
                    errorMessage = powerCut.value.message!!
                )
            }
        }

    }

}