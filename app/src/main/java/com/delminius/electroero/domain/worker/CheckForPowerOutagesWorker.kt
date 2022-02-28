package com.delminius.electroero.domain.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.*
import com.delminius.electroero.domain.use_cases.UseCases
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.datetime.*
import com.delminius.electroero.R
import com.delminius.electroero.domain.notification.LocalNotification
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@HiltWorker
class CheckForPowerOutagesWorker @AssistedInject constructor(
    @Assisted val context: Context,
    @Assisted workerParameters: WorkerParameters,
    private val outagesNotification: LocalNotification,
    private val useCases: UseCases
) : CoroutineWorker(context, workerParameters) {

    private val firstPowerCutDay: LocalDate = Clock.System.todayAt(TimeZone.currentSystemDefault())
    private val secondPowerCutDay = firstPowerCutDay.plus(1, DateTimeUnit.DAY)
    private val thirdPowerCutDay = firstPowerCutDay.plus(2, DateTimeUnit.DAY)


    override suspend fun doWork(): Result {

        val isSecondDayActive = checkForActiveDay(secondPowerCutDay)
        val isThirdDayActive = checkForActiveDay(thirdPowerCutDay)

        if (isSecondDayActive || isThirdDayActive) {
            Log.d("ovde", isSecondDayActive.toString())
            outagesNotification.showIsPowerOutageNotification(
                body = context.getString(R.string.outages_desc)
            )
        }

        return Result.success()
    }

    private suspend fun checkForActiveDay(date: LocalDate): Boolean {
        val activeBranchesCall =
            useCases.getPowerCutOfficeUseCase.invoke(date = date.toString()).data

        val allBranchesInDb = useCases.getAllBranchesForCompare.invoke()

        val difference =
            allBranchesInDb.filter { it.id in activeBranchesCall!!.map { item -> item.branchOfficeId } }

        Log.d("ovde", activeBranchesCall.toString())

        return difference.isNotEmpty()
    }
}