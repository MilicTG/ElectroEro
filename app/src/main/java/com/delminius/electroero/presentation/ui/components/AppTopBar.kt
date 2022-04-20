package com.delminius.electroero.presentation.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.delminius.electroero.R

@Composable
fun AppTopBar(
    title: String,
    scrollBehavior: TopAppBarScrollBehavior,
    onInfoClicked: () -> Unit
) {
    LargeTopAppBar(
        title = {
            Text(
                text = title,
            )
        },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            scrolledContainerColor = MaterialTheme.colorScheme.background,
        ),
        scrollBehavior = scrollBehavior,
        actions = {
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