package com.delminius.electroero.domain.worker

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.hilt.work.HiltWorker
import androidx.work.*
import com.delminius.electroero.domain.use_cases.UseCases
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.datetime.*
import com.delminius.electroero.R
import com.delminius.electroero.domain.model.BranchOfficesItem
import com.delminius.electroero.presentation.activity.MainActivity
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@HiltWorker
class CheckForPowerOutagesWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParameters: WorkerParameters,
    private val useCases: UseCases
) : CoroutineWorker(context, workerParameters) {

    private val firstPowerCutDay: LocalDate = Clock.System.todayAt(TimeZone.currentSystemDefault())
    private val secondPowerCutDay = firstPowerCutDay.plus(1, DateTimeUnit.DAY)


    override suspend fun doWork(): Result {
        val activeBranchesCall =
            useCases.getPowerCutOfficeUseCase(date = secondPowerCutDay.toString()).data?.toList()


        val allBranchesInDb = useCases.getAllBranchesForCompare.invoke()

        val difference =
            allBranchesInDb.filter { it.id in activeBranchesCall!!.map { item -> item.branchOfficeId } }

        Log.d("ovde", difference.toString())

        setForeground(createForegroundInfo(difference))

        return Result.success(workDataOf("OUTAGES" to difference))
    }

    private fun createForegroundInfo(listOfOutages: List<BranchOfficesItem>): ForegroundInfo {
        val intent = Intent(applicationContext, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent = PendingIntent.getActivity(applicationContext, 0, intent, 0)

        val listContent: String = listOfOutages.map { it.name }.toString()

        val notification = NotificationCompat.Builder(
            applicationContext, "workOutages"
        )
            .setContentTitle("Planirani radovi")
            .setContentText(listContent)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("Much longer text that cannot fit one line...")
            )
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel(notification, "workOutages")
        }
        return ForegroundInfo(1, notification.build())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createChannel(
        notificationBuilder: NotificationCompat.Builder,
        id: String
    ) {
        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as
                    NotificationManager
        notificationBuilder.setDefaults(Notification.DEFAULT_VIBRATE)
        val channel = NotificationChannel(
            id,
            "Êléktra",
            NotificationManager.IMPORTANCE_HIGH
        )
        channel.description = "Êléktra Notifications"
        notificationManager.createNotificationChannel(channel)
    }
}