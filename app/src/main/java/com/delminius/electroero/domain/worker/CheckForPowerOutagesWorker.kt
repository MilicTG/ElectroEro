package com.delminius.electroero.domain.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.delminius.electroero.domain.use_cases.UseCases
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayAt

@HiltWorker
class CheckForPowerOutagesWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParameters: WorkerParameters,
    private val useCases: UseCases
) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        val firstPowerCutDay: LocalDate = Clock.System.todayAt(TimeZone.currentSystemDefault())

        val activeBranchOffices =
            useCases.getPowerCutOfficeUseCase(date = firstPowerCutDay.toString()).data
        val allBranchesInDb = useCases.getAllBranchesForCompare.invoke()

        val diffrence =
            allBranchesInDb.filter { it.id !in activeBranchOffices!!.map { item -> item.id } }
        Log.d("ovde", diffrence.toString())

        return Result.success()
    }
}