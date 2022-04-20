package com.delminius.electroero.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.delminius.electroero.presentation.ui.theme.*
import com.delminius.electroero.util.getDayFromDateString

@Composable
fun PowerCutDayCard(
    branchName: String,
    powerCutLocation: String,
    powerCutTimeFrom: String,
    powerCutTimeTo: String
) {
    Card(
        modifier = Modifier
            .padding(
                horizontal = LARGE_PADDING,
                vertical = NORMAL_PADDING
            )
            .fillMaxWidth(),
        shape = Shapes.large,
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
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
                        top = NORMAL_PADDING,
                    )
            )
            Text(
                text = powerCutLocation,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.body2.fontSize
                ),
                modifier = Modifier
                    .padding(
                        horizontal = NORMAL_PADDING,
                        vertical = SMALL_PADDING
                    )
            )
            Divider(
                color = MaterialTheme.colors.onPrimary.copy(alpha = 0.3f),
                thickness = 1.dp,
                modifier = Modifier
                    .padding(
                        horizontal = NORMAL_PADDING,
                        vertical = SMALL_PADDING
                    )
            )
            Text(
                text = "Vrijeme nestanka struje: ${getDayFromDateString(powerCutTimeFrom)} - ${getDayFromDateString(powerCutTimeTo)}",
                style = TextStyle(
                    fontSize = MaterialTheme.typography.body1.fontSize
                ),
                modifier = Modifier
                    .padding(
                        horizontal = NORMAL_PADDING,
                        vertical = LARGE_PADDING
                    )
            )
        }
    }
}