package com.delminius.electroero.presentation.ui.screens.subscriptions

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SubscriptionsScreen(
    subscriptionViewModel: SubscriptionViewModel = hiltViewModel()
) {

    val allSubscriptions = subscriptionViewModel.allBranchesSubscriptionState.value

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = allSubscriptions.subscribedBranches.toString())
        }
    }
}