package com.delminius.electroero.presentation.ui.components

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
fun PowerCutNoWorkCard(

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
    ) {
        Text(
            text = "Nema planiranih radova",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = MaterialTheme.typography.h6.fontSize
            ),
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(
                    all = LARGE_PADDING
                )
        )
    }
}