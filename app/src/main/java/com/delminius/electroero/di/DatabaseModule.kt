package com.delminius.electroero.di

import android.content.Context
import androidx.room.Room
import com.delminius.electroero.data.local.ElektraDatabase
import com.delminius.electroero.data.repository.LocalDataSourceImpl
import com.delminius.electroero.domain.repository.LocalDataSource
import com.delminius.electroero.util.Constants.ELEKTRA_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): ElektraDatabase {
        return Room.databaseBuilder(
            context,
            ElektraDatabase::class.java,
            ELEKTRA_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(
        database: ElektraDatabase
    ): LocalDataSource {
        return LocalDataSourceImpl(
            elektraDao = database.elektraDao()
        )
    }
}