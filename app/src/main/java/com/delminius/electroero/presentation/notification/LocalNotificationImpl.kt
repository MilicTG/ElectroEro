package com.delminius.electroero.presentation.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.delminius.electroero.R
import com.delminius.electroero.domain.notification.LocalNotification
import com.delminius.electroero.presentation.activity.MainActivity
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject

@InternalCoroutinesApi
class LocalNotificationImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : LocalNotification {

    override fun showIsPowerOutageNotification(body: String) {
        val notification = getNotification(
            channelId = OUTAGES_CHANNEL_ID,
            channelName = R.string.outages_title,
            notifyDescription = R.string.outages_desc,
            notifyImportance = NotificationManager.IMPORTANCE_DEFAULT,
            priority = NotificationCompat.PRIORITY_HIGH,
            title = context.getString(R.string.outages_title),
            text = body
        )

        val mainIntent = PendingIntent.getActivity(
            context,
            0,
            Intent(
                context, MainActivity::class.java
            ),
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
                PendingIntent.FLAG_UPDATE_CURRENT
            } else {
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            }
        )

        notification.setContentIntent(mainIntent)

        NotificationManagerCompat
            .from(context.applicationContext)
            .notify(OUTAGES_NOTIFICATION_ID, notification.build())
    }

    private fun getNotification(
        channelId: String,
        channelName: Int,
        notifyDescription: Int,
        notifyImportance: Int,
        priority: Int,
        title: String,
        text: String
    ): NotificationCompat.Builder {
        val builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(text)
            .setPriority(priority)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = context.getString(channelName)
            val descriptionText = context.getString(notifyDescription)
            val channel = NotificationChannel(channelId, name, notifyImportance)
            channel.description = descriptionText

            NotificationManagerCompat.from(context).createNotificationChannel(channel)
        }

        return builder
    }

    companion object {
        const val OUTAGES_CHANNEL_ID = "outages_channel_id"
        const val OUTAGES_NOTIFICATION_ID = 1919
    }
}