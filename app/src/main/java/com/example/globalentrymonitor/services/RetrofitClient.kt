package com.example.globalentrymonitor.services

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {


    val api: WebClient by lazy {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

         Retrofit.Builder()
            .client(OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build())
            .baseUrl("https://ttp.cbp.dhs.gov/schedulerapi/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebClient::class.java)
    }
}