package com.mj.notificationlistenerservice.service

import com.mj.notificationlistenerservice.model.NotificationsData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface NotificationService {
    @POST("/notification")
    fun sendNotification(@Body notification: NotificationsData): Call<Void>
}
