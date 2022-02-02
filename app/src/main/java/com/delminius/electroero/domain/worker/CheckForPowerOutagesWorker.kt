package com.delminius.electroero.domain.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.delminius.electroero.data.local.dao.ElektraDao
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class CheckForPowerOutagesWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParameters: WorkerParameters,
    private val dao: ElektraDao
) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        val allBranchesInDb = dao.getAllBranches()

        return Result.success()
    }
}