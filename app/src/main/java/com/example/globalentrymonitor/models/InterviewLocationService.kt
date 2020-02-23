package com.example.globalentrymonitor.models

import com.google.gson.annotations.SerializedName

data class InterviewLocationService(

    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)