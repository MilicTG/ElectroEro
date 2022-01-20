package com.delminius.electroero.presentation.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.delminius.electroero.R
import com.delminius.electroero.presentation.ui.theme.DarkBackgroundAndTextColor

@Composable
fun AppHomeTopBar(
    title: String,
    onRefreshClicked: () -> Unit,
    onInfoClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = title,
            )
        },
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.background,
        contentColor = DarkBackgroundAndTextColor,
        actions = {
            IconButton(
                onClick = { onRefreshClicked() }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_refresh),
                    contentDescription = "Refresh"
                )
            }
            IconButton(
                onClick = { onInfoClicked() }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_info),
                    contentDescription = "Screen Info"
                )
            }
        }
    )
}