package com.delminius.electroero.util

import com.delminius.electroero.util.Constants.DATE_PATTERN
import java.text.SimpleDateFormat
import java.util.*


fun Date.toString(format: String, locale: Locale = Locale("Hr", "hr")): String {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this)
}

fun getDateOrDayForSpecificDay(day: String): String {
    val calendar = Calendar.getInstance()

    return when (day) {
        "firstDate" -> calendar.time.toString(format = DATE_PATTERN)
        "secondDate" -> calendar.apply {
            add(Calendar.DAY_OF_YEAR, 1)
        }.time.toString(format = DATE_PATTERN)
        "thirdDate" -> calendar.apply {
            add(Calendar.DAY_OF_YEAR, 2)
        }.time.toString(format = DATE_PATTERN)
        else -> ""
    }
}

fun getDayFromDateString(dateString: String, locale: Locale = Locale("US", "us")): String {
    return dateString.removeRange(startIndex = 0, endIndex = 11).dropLast(3)
}