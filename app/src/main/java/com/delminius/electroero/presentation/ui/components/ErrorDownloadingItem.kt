package com.delminius.electroero.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.delminius.electroero.R
import com.delminius.electroero.presentation.ui.theme.*

@Composable
fun ErrorDownloadingComponent(
    errorMessage: String
) {

    Card(
        modifier = Modifier
            .padding(
                horizontal = LARGE_PADDING,
                vertical = NORMAL_PADDING
            )
            .fillMaxWidth(),
        shape = Shapes.large,
        backgroundColor = PastelRedColor,
        contentColor = DarkBackgroundAndTextColor,
        elevation = CARD_ELEVATION
    ) {


        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = NORMAL_PADDING),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_error),
                contentDescription = "Error icon",
                tint = Color.White,
                modifier = Modifier.size(IMAGE_ITEM_SIZE)
            )
            Text(
                text = errorMessage,
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize
                ),
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(
                        horizontal = NORMAL_PADDING,
                        vertical = LARGE_PADDING
                    )
            )
        }
    }
}