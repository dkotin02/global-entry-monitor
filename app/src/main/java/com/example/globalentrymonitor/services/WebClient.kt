package com.example.globalentrymonitor.services

import com.example.globalentrymonitor.models.InterviewLocation
import com.example.globalentrymonitor.models.OpenTime
import retrofit2.http.GET
import retrofit2.http.Query

interface WebClient {

    @GET("locations/")
    suspend fun getLocations(
        @Query("temporary") temporary: Boolean = false,
        @Query("inviteOnly") inviteOnly: Boolean = false,
        @Query("operational") operational: Boolean = true,
        @Query("serviceName") serviceName: String = "Global Entry"
    ): ArrayList<InterviewLocation>

    @GET("slots")
    suspend fun getTimes(
        @Query("orderBy") order: String = "soonest",
        @Query("limit") limit: Int = 10,
        @Query("locationId") locationId: String
    ): ArrayList<OpenTime>
}
