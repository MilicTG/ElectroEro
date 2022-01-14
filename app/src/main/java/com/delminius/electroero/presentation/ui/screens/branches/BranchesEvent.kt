package com.delminius.electroero.presentation.ui.screens.branches

import com.delminius.electroero.domain.model.BranchOfficesItem

sealed class BranchesEvent {
    object OnBranchInfoClicked : BranchesEvent()
    data class OnSubscribeToBranchClicked(
        val branchOfficesItem: BranchOfficesItem
    ) : BranchesEvent()
}
