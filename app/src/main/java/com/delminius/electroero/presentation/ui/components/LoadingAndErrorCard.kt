package com.delminius.electroero.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.delminius.electroero.presentation.ui.theme.*

@Composable
fun LoadingAndErrorCard(
    isDownloading: Boolean,
    isError: Boolean,
    errorMessage: String,
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

        val text = when {
            isDownloading -> {
                "Preuzimanje molimo pričekajte."
            }
            isError -> {
                errorMessage
            }
            else -> {
                "Nepoznata greška"
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = NORMAL_PADDING,
                    vertical = SMALL_PADDING
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(
                        vertical = LARGE_PADDING,
                        horizontal = NORMAL_PADDING
                    ),
                color = PastelRedColor
            )

            Text(
                text = text,
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize
                ),
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(
                        start = NORMAL_PADDING,
                        end = NORMAL_PADDING,
                        top = NORMAL_PADDING,
                    )
            )
        }
    }
}