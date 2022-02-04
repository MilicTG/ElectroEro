package com.delminius.electroero.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.work.*
import com.delminius.electroero.domain.worker.CheckForPowerOutagesWorker
import com.delminius.electroero.presentation.ui.screens.container.ContainerScreen
import com.delminius.electroero.presentation.ui.theme.ElectroEroTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val workManager by lazy {
        WorkManager.getInstance(applicationContext)
    }

    private val workerConstraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .setRequiresStorageNotLow(true)
        .setRequiresBatteryNotLow(true)
        .build()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ElectroEroTheme {
                val navController = rememberNavController()
                ContainerScreen(
                    navController = navController
                )
            }
        }

        createPeriodicWorkRequest()
    }

    private fun createPeriodicWorkRequest() {
        val branchWork = OneTimeWorkRequestBuilder<CheckForPowerOutagesWorker>()
            .setConstraints(workerConstraints)
            .addTag("branchWork")
            .build()

        workManager.enqueueUniqueWork(
            "oneTimeWorker",
            ExistingWorkPolicy.KEEP,
            branchWork
        )
    }
}
