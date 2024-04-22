package com.mj.notificationlistenerservice.service

import android.app.Notification
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import com.mj.notificationlistenerservice.model.NotificationsData
import com.mj.notificationlistenerservice.service.NotificationClient.service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NotificationListener: NotificationListenerService() {

//    override fun onNotificationPosted(sbn: StatusBarNotification?) {
//        super.onNotificationPosted(sbn)
//        val notiInfo = sbn?.notification ?: return
//        val packageName = sbn.packageName ?:return
//        val title = notiInfo.extras.getString(Notification.EXTRA_TITLE)
//        val text = notiInfo.extras.getString(Notification.EXTRA_TEXT)
//        val subText = notiInfo.extras.getString(Notification.EXTRA_SUB_TEXT)
//
//        Log.d("NotificationListener","onNotificationPosted - package name: $packageName, title : $title, text : $text, subText : $subText")
//
//    }

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)
        val notiInfo = sbn?.notification ?: return
        val packageName = sbn.packageName ?: return
        val title = notiInfo.extras.getString(Notification.EXTRA_TITLE)
        val text = notiInfo.extras.getString(Notification.EXTRA_TEXT)
        val subText = notiInfo.extras.getString(Notification.EXTRA_SUB_TEXT)
        Log.d("NotificationListener","onNotificationPosted - package name: $packageName, title : $title, text : $text")
        val notificationData = NotificationsData(packageName, title, text)

        service.sendNotification(notificationData).enqueue(object : Callback<Void> {
           override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Log.d("NotificationListener", "Notifikasi berhasil di POST")
                } else {
                    Log.e("NotificationListener", "Humm kenapa: ${response.message()}")
                }
            }

           override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.e("NotificationListener", "Gagal mengirim: ${t.message}")
            }
        })
    }


    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        super.onNotificationRemoved(sbn)

        val notiInfo = sbn?.notification ?: return

        val title = notiInfo.extras.getString(Notification.EXTRA_TITLE)
        val text = notiInfo.extras.getString(Notification.EXTRA_TEXT)
        val subText = notiInfo.extras.getString(Notification.EXTRA_SUB_TEXT)

        Log.d("NotificationListener","onNotificationRemoved - title : $title, text : $text")
    }
}