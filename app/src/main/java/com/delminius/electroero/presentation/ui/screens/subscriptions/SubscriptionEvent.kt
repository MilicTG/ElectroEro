package com.delminius.electroero.presentation.ui.screens.subscriptions

import com.delminius.electroero.domain.model.BranchOfficesItem

sealed class SubscriptionEvent {
    object OnBranchInfoClicked : SubscriptionEvent()

    data class OnDeleteBranchClicked(
        val branchOfficesItem: BranchOfficesItem
    ) : SubscriptionEvent()
}