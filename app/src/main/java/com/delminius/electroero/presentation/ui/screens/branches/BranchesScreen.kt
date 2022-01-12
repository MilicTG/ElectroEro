package com.delminius.electroero.presentation.ui.screens.branches

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.delminius.electroero.R
import com.delminius.electroero.domain.model.BranchOffices
import com.delminius.electroero.presentation.ui.components.BranchesListCard
import com.delminius.electroero.presentation.ui.components.DownloadingInProgress
import com.delminius.electroero.presentation.ui.components.ErrorDownloadingComponent
import com.delminius.electroero.presentation.ui.components.TopAppHeader
import com.delminius.electroero.presentation.ui.theme.BOTTOM_PADDING
import com.delminius.electroero.presentation.ui.theme.NORMAL_PADDING
import com.delminius.electroero.presentation.ui.theme.SMALL_PADDING
import com.delminius.electroero.util.Resource

@Composable
fun BranchesScreen(
    branchesViewModel: BranchesViewModel = hiltViewModel()
) {

    val branches = branchesViewModel.allBranchOffices.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = BOTTOM_PADDING),
    ) {
        TopAppHeader(
            headerTitle = stringResource(R.string.branches),
            headerSubtitle = stringResource(R.string.all_branches),
            onInfoButtonClicked = {}
        )

        when (branches.value) {
            is Resource.Success -> {
                LazyColumn(
                    contentPadding = PaddingValues(
                        vertical = NORMAL_PADDING,
                        horizontal = SMALL_PADDING
                    )
                ) {
                    items(
                        branches.value.data!!.size,
                    ) { branchOffice ->
                        BranchesListCard(
                            branchName = branches.value.data!![branchOffice].name,
                            onSubscribeClicked = {}
                        )
                    }
                }
            }
            is Resource.Error -> {
                ErrorDownloadingComponent(
                    errorMessage = branches.value.message!!
                )
            }
            is Resource.Loading -> {
                DownloadingInProgress()
            }
        }
    }
}