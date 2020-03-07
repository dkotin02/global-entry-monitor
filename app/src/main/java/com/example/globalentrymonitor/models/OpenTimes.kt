package com.example.globalentrymonitor.models

import java.text.SimpleDateFormat
import java.util.*

data class OpenTime(
val locationId: Int,
val startTimestamp: String,
val endTimestamp: String,
val active: Boolean,
val duration: Int
)

fun OpenTime.startTime(timeZone: String): Date? {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm",
            Locale.getDefault())
        dateFormat.timeZone = TimeZone.getTimeZone(timeZone)
        return dateFormat.parse(startTimestamp)
}
fun OpenTime.endTime(timeZone: String): Date? {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm",
            Locale.getDefault())
        dateFormat.timeZone = TimeZone.getTimeZone(timeZone)
        return dateFormat.parse(startTimestamp)
}