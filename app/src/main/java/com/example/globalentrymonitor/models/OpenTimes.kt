package com.example.globalentrymonitor.models

data class OpenTime(
val locationId: Int,
val startTimestamp: String,
val endTimestamp: String,
val active: Boolean,
val duration: Int
)