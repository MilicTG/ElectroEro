package com.delminius.electroero.presentation.ui.screens.branches

import com.delminius.electroero.domain.model.BranchOfficesItem

sealed class BranchesEvent{
    object OnBranchInfoClicked: BranchesEvent()
    data class OnSubscribeClicked(val branchOfficesItem: BranchOfficesItem): BranchesEvent()
    object OnCancelSubscribeClicked: BranchesEvent()
}
