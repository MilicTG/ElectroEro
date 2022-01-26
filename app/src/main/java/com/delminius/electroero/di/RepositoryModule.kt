package com.delminius.electroero.di

import com.delminius.electroero.data.repository.Repository
import com.delminius.electroero.domain.use_cases.*
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
            getPowerCutOfficeUseCase = GetPowerCutOfficeUseCase(repository = repository),
            getAllElektraSubscriptionUseCase = GetAllElektraSubscriptionUseCase(repository = repository),
            addToBranchSubscriptionUseCase = AddToBranchSubscriptionUseCase(repository = repository)
        )
    }
}