package com.delminius.electroero.di

import android.content.Context
import com.delminius.electroero.domain.notification.LocalNotification
import com.delminius.electroero.presentation.notification.LocalNotificationImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Singleton

@InternalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {

    @Provides
    @Singleton
    fun providesOutagesNotification(
        @ApplicationContext context: Context
    ): LocalNotification {
        return LocalNotificationImpl(context = context)
    }
}