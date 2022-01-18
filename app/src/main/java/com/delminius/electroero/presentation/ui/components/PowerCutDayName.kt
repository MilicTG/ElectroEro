package com.delminius.electroero.presentation.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import com.delminius.electroero.presentation.ui.theme.EXTRA_LARGE_PADDING
import com.delminius.electroero.presentation.ui.theme.LARGE_PADDING
import com.delminius.electroero.presentation.ui.theme.SMALL_PADDING

@Composable
fun PowerCutDayName(day: String) {
    Text(
        text = day.capitalize(
            Locale("Hr"),

            ),
        style = MaterialTheme.typography.body1.copy(
            fontWeight = FontWeight.SemiBold
        ),
        modifier = Modifier
            .padding(
                start = LARGE_PADDING,
                end = LARGE_PADDING,
                top = EXTRA_LARGE_PADDING,
                bottom = SMALL_PADDING
            )
    )
}