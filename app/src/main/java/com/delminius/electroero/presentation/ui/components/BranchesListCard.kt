package com.delminius.electroero.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.delminius.electroero.R
import com.delminius.electroero.presentation.ui.theme.*

@Composable
fun BranchesListCard(
    branchName: String,
    onSubscribeClicked: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(
                horizontal = LARGE_PADDING,
                vertical = SEMI_LARGE_PADDING
            )
            .fillMaxWidth(),
        shape = Shapes.large,
        backgroundColor = PastelBlueColor,
        contentColor = DarkBackgroundAndTextColor,
        elevation = CARD_ELEVATION
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    all = NORMAL_PADDING
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = branchName,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h6.copy(
                    fontWeight = FontWeight.Medium
                )
            )
            IconButton(onClick = { onSubscribeClicked() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "Subscribe to branch",
                    tint = DarkBackgroundAndTextColor,
                    modifier = Modifier.size(CARD_ICON_SIZE)
                )
            }
        }
    }
}