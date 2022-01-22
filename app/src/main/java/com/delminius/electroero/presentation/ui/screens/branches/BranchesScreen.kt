package com.delminius.electroero.presentation.ui.screens.branches

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.delminius.electroero.domain.model.SnackBarContent
import com.delminius.electroero.presentation.ui.components.BranchesListCard
import com.delminius.electroero.presentation.ui.components.DownloadingInProgress
import com.delminius.electroero.presentation.ui.components.ErrorDownloadingComponent
import com.delminius.electroero.presentation.ui.theme.BOTTOM_PADDING
import com.delminius.electroero.presentation.ui.theme.LARGE_PADDING
import com.delminius.electroero.presentation.ui.theme.NORMAL_PADDING
import com.delminius.electroero.presentation.ui.theme.SMALL_PADDING
import com.delminius.electroero.util.Resource

@Composable
fun BranchesScreen(
    onSubscribeClicked: (SnackBarContent) -> Unit,
    branchesViewModel: BranchesViewModel = hiltViewModel()
) {
    val branches = branchesViewModel.allBranchOffices.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = BOTTOM_PADDING),
    ) {
        when (branches.value) {
            is Resource.Success -> {
                LazyColumn(
                    contentPadding = PaddingValues(
                        top = SMALL_PADDING,
                        bottom = LARGE_PADDING
                    )
                ) {
                    items(
                        branches.value.data!!.size,
                    ) { branchOffice ->
                        BranchesListCard(
                            branchName = branches.value.data!![branchOffice].name,
                            onSubscribeClicked = {
                                onSubscribeClicked(
                                    SnackBarContent(
                                        snackMessage = "Poslovnica dodana",
                                        snackAction = "Poništi"
                                    )
                                )
                            }
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