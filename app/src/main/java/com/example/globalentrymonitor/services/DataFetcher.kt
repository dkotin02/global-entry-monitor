package com.example.globalentrymonitor.services

import com.example.globalentrymonitor.models.InterviewLocation
import com.example.globalentrymonitor.models.OpenTime

interface IDataFetcher {
    suspend fun getTimes(locationId: String): ArrayList<OpenTime>

    suspend fun getLocations(): ArrayList<InterviewLocation>
}

class DataFetcher : IDataFetcher {

    private val client by lazy { RetrofitClient.api }

    override suspend fun getTimes(locationId: String) = client.getTimes(locationId = locationId)

    override suspend fun getLocations() = client.getLocations()
}