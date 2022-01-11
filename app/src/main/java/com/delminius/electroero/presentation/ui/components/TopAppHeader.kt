package com.delminius.electroero.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.delminius.electroero.R
import com.delminius.electroero.presentation.ui.theme.DarkBackgroundAndTextColor
import com.delminius.electroero.presentation.ui.theme.INFO_ICON_SIZE
import com.delminius.electroero.presentation.ui.theme.LARGE_PADDING

@Composable
fun TopAppHeader(
    headerTitle: String,
    headerSubtitle: String,
    onInfoButtonClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = LARGE_PADDING),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = headerTitle,
                style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = headerSubtitle,
                style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Light)
            )
        }
        IconButton(
            onClick = { onInfoButtonClicked() }
        )
        {
            Icon(
                painter = painterResource(id = R.drawable.ic_info),
                contentDescription = "Info Button",
                modifier = Modifier.size(INFO_ICON_SIZE),
                tint = DarkBackgroundAndTextColor
            )
        }
    }
}