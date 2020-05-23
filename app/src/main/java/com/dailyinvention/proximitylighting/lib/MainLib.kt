package com.dailyinvention.proximitylighting.lib

import android.provider.BaseColumns
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object timeFunctions {
    fun convertMilitaryAndStandard(timeString: String, toMilitary: Boolean): String {
        // load the string to a date
        val formatToDate: DateFormat =
            if (toMilitary == false) SimpleDateFormat(
                "HH:mm",
                Locale.US
            ) else SimpleDateFormat("h:mm a", Locale.US)
        val formattedDate: Date = formatToDate.parse(timeString) as Date
        // convert the date back to a standard time-formatted string
        val formatToString: DateFormat =
            if (toMilitary == false) SimpleDateFormat(
                "h:mm a",
                Locale.US
            ) else SimpleDateFormat("HH:mm", Locale.US)
        val formattedString: String = formatToString.format(formattedDate)
        return formattedString
    }
}