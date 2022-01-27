package com.delminius.electroero.presentation.ui.screens.subscriptions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.delminius.electroero.domain.model.SnackBarContent
import com.delminius.electroero.presentation.ui.components.SubscriptionListCard
import com.delminius.electroero.presentation.ui.theme.BOTTOM_PADDING
import com.delminius.electroero.presentation.ui.theme.LARGE_PADDING
import com.delminius.electroero.presentation.ui.theme.SMALL_PADDING

@Composable
fun SubscriptionsScreen(
    onDeleteClicked: (SnackBarContent) -> Unit,
    subscriptionViewModel: SubscriptionViewModel = hiltViewModel()
) {

    val allSubscriptions = subscriptionViewModel.allBranchesSubscriptionState.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = BOTTOM_PADDING),
    ) {
        if (allSubscriptions.subscribedBranches.isEmpty()) {
            Text(text = "Nema pretplata", style = MaterialTheme.typography.h6)
        } else {
            LazyColumn(
                contentPadding = PaddingValues(
                    top = SMALL_PADDING,
                    bottom = LARGE_PADDING
                )
            ) {
                items(allSubscriptions.subscribedBranches.size) { branch ->
                    SubscriptionListCard(
                        branchId = allSubscriptions.subscribedBranches[branch].id,
                        branchName = allSubscriptions.subscribedBranches[branch].name,
                        onDeleteClicked = {
                            subscriptionViewModel.onEvent(
                                SubscriptionEvent.OnDeleteBranchClicked(allSubscriptions.subscribedBranches[branch])
                            )
                            onDeleteClicked(
                                SnackBarContent(
                                    snackMessage = "Poslovnica izbrisana",
                                    snackAction = "Vrati"
                                )
                            )
                        }
                    )
                }
            }
        }
    }
}