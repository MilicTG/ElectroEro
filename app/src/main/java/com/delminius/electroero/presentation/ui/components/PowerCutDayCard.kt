package com.delminius.electroero.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.delminius.electroero.presentation.ui.theme.*

@Composable
fun PowerCutDayCard(
    background: Color,
    branchName: String,
    powerCutLocation: String,
    powerCutTime: String
) {
    Card(
        modifier = Modifier
            .padding(
                horizontal = LARGE_PADDING,
                vertical = NORMAL_PADDING
            )
            .fillMaxWidth(),
        shape = Shapes.large,
        backgroundColor = background,
        contentColor = DarkBackgroundAndTextColor,
        elevation = CARD_ELEVATION
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = NORMAL_PADDING),
        ) {
            Text(
                text = branchName,
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = MaterialTheme.typography.h6.fontSize
                ),
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(
                        start = NORMAL_PADDING,
                        end = NORMAL_PADDING,
                        top = LARGE_PADDING,
                        bottom = SMALL_PADDING
                    )
            )
            Text(
                text = powerCutLocation,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.body2.fontSize
                ),
                modifier = Modifier
                    .padding(
                        all = NORMAL_PADDING,
                    )
            )
        }
    }
}