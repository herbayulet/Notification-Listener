package com.mj.notificationlistenerservice.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NotificationClient {
    private const val BASE_URL = "http://192.168.180.75:9090"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service: NotificationService by lazy {
        retrofit.create(NotificationService::class.java)
    }
}
