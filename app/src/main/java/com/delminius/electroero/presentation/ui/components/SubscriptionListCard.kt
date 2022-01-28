package com.delminius.electroero.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.delminius.electroero.R
import com.delminius.electroero.presentation.ui.theme.*

@Composable
fun SubscriptionListCard(
    branchId: Int,
    branchName: String,
    onDeleteClicked: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(
                all = SEMI_LARGE_PADDING
            )
            .fillMaxWidth(),
        shape = Shapes.large,
        backgroundColor = PastelYellowColor,
        contentColor = DarkBackgroundAndTextColor,
        elevation = CARD_ELEVATION
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = NORMAL_PADDING
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = branchName,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.body2.copy(
                    fontWeight = FontWeight.Medium
                )
            )
            IconButton(onClick = { onDeleteClicked(branchId) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = "Delete subscription",
                    tint = DarkBackgroundAndTextColor,
                    modifier = Modifier.size(CARD_ICON_SIZE)
                )
            }
        }
    }
}