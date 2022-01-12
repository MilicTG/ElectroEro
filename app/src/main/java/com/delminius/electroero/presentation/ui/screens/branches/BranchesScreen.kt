package com.delminius.electroero.presentation.ui.screens.branches

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.delminius.electroero.R
import com.delminius.electroero.presentation.ui.components.TopAppHeader
import com.delminius.electroero.util.Resource

@Composable
fun BranchesScreen(
    branchesViewModel: BranchesViewModel = hiltViewModel()
) {

val branches = produceState<Resource<BranchOffices>>(initialValue = Resource.Loading()){
    value = branchesViewModel.getAllBranchOffices()
}
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        TopAppHeader(
            headerTitle = stringResource(R.string.branches),
            headerSubtitle = stringResource(R.string.all_branches),
            onInfoButtonClicked = {}
        )

        when(branches.value) {
            is  Resource.Success -> {
                Text(
                    text = branches.value.data.toString(),
                    color = Color.Red,
                )
            }
            is Resource.Error -> {
                Text(
                    text = branches.value.message!!,
                    color = Color.Red
                )
            }
            is Resource.Loading -> {
                CircularProgressIndicator(
                    color = Color.Red
                )
            }
        }
    }
}