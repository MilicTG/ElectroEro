package com.delminius.electroero.di

import com.delminius.electroero.data.repository.Repository
import com.delminius.electroero.domain.use_cases.GetAllBranchOfficesUseCase
import com.delminius.electroero.domain.use_cases.GetPowerCutOfficeUseCase
import com.delminius.electroero.domain.use_cases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            getAllBranchOfficesUseCase = GetAllBranchOfficesUseCase(repository = repository),
            getPowerCutOfficeUseCase = GetPowerCutOfficeUseCase(repository = repository)
        )
    }
}