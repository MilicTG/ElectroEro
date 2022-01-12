package com.delminius.electroero.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
                vertical = NORMAL_PADDING
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
                .padding(horizontal = NORMAL_PADDING),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = branchName,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            IconButton(onClick = { onSubscribeClicked() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "Subscribe to branch",
                    tint = DarkBackgroundAndTextColor
                )
            }
        }
    }
}