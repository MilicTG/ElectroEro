package com.delminius.electroero.presentation.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.hilt.navigation.compose.hiltViewModel
import com.delminius.electroero.R
import com.delminius.electroero.presentation.ui.components.*
import com.delminius.electroero.presentation.ui.theme.*
import com.delminius.electroero.util.Resource

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val firstDayPowerCutDayList = homeViewModel.firstDayPowerCutDayList.collectAsState()
    val secondDayPowerCutDayList = homeViewModel.secondDayPowerCutDayList.collectAsState()
    val thirdDayPowerCutDayList = homeViewModel.thirdDayPowerCutDayList.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = BOTTOM_PADDING),
    ) {
        TopAppHeader(
            headerTitle = stringResource(R.string.welcome),
            headerSubtitle = stringResource(R.string.home_subtitle),
            onInfoButtonClicked = {}
        )

        LazyColumn(
            contentPadding = PaddingValues(
                vertical = NORMAL_PADDING,
                horizontal = SMALL_PADDING
            )
        ) {
            item {
                PowerCutDayName(day = homeViewModel.firstDayText)
            }
            when (firstDayPowerCutDayList.value) {
                is Resource.Loading -> {
                    item { DownloadingInProgress() }
                }
                is Resource.Success -> {
                    items(firstDayPowerCutDayList.value.data!!.size) { powerCutItem ->
                        PowerCutDayCard(
                            background = PastelBlueColor,
                            branchName = firstDayPowerCutDayList.value.data!![powerCutItem].branchOfficeName,
                            powerCutLocation = firstDayPowerCutDayList.value.data!![powerCutItem].location,
                            powerCutTime = firstDayPowerCutDayList.value.data!![powerCutItem].dateFrom
                        )
                    }
                }
                is Resource.Error -> {
                    item {
                        ErrorDownloadingComponent(
                            errorMessage = firstDayPowerCutDayList.value.message!!
                        )
                    }
                }
            }

            item {
                PowerCutDayName(day = homeViewModel.secondDayText)
            }
            when (secondDayPowerCutDayList.value) {
                is Resource.Loading -> {
                    item { DownloadingInProgress() }
                }
                is Resource.Success -> {
                    items(secondDayPowerCutDayList.value.data!!.size) { powerCutItem ->
                        PowerCutDayCard(
                            background = PastelYellowColor,
                            branchName = secondDayPowerCutDayList.value.data!![powerCutItem].branchOfficeName,
                            powerCutLocation = secondDayPowerCutDayList.value.data!![powerCutItem].location,
                            powerCutTime = secondDayPowerCutDayList.value.data!![powerCutItem].dateFrom
                        )
                    }
                }
                is Resource.Error -> {
                    item {
                        ErrorDownloadingComponent(
                            errorMessage = secondDayPowerCutDayList.value.message!!
                        )
                    }
                }
            }

            item {
                PowerCutDayName(day = homeViewModel.thirdDayText)
            }
            when (thirdDayPowerCutDayList.value) {
                is Resource.Loading -> {
                    item { DownloadingInProgress() }
                }
                is Resource.Success -> {
                    items(thirdDayPowerCutDayList.value.data!!.size) { powerCutItem ->
                        PowerCutDayCard(
                            background = PastelRedColor,
                            branchName = thirdDayPowerCutDayList.value.data!![powerCutItem].branchOfficeName,
                            powerCutLocation = thirdDayPowerCutDayList.value.data!![powerCutItem].location,
                            powerCutTime = thirdDayPowerCutDayList.value.data!![powerCutItem].dateFrom
                        )
                    }
                }
                is Resource.Error -> {
                    item {
                        ErrorDownloadingComponent(
                            errorMessage = thirdDayPowerCutDayList.value.message!!
                        )
                    }
                }
            }
        }
    }
}

