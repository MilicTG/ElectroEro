package com.delminius.electroero.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
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
fun LoadingAndErrorCard(
    isDownloading: Boolean,
    isError: Boolean,
    errorMessage: String,
    background: Color,
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
                .padding(horizontal = NORMAL_PADDING),
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(SPINNER_DOWNLOADING_SIZE)
                    .padding(bottom = EXTRA_LARGE_PADDING),
                color = MaterialTheme.colors.secondary
            )

            Text(
                text = text,
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
        }
    }
}