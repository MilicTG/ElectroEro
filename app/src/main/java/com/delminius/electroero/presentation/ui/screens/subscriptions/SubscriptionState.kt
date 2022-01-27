package com.delminius.electroero.presentation.ui.screens.subscriptions

import com.delminius.electroero.domain.model.BranchOfficesItem

data class SubscriptionState(
    val subscribedBranches: List<BranchOfficesItem> = emptyList()
)
