package com.delminius.electroero.data.repository

import com.delminius.electroero.domain.model.BranchOffices
import com.delminius.electroero.domain.model.BranchOfficesItem
import com.delminius.electroero.domain.model.PowerCutOffice
import com.delminius.electroero.domain.repository.LocalDataSource
import com.delminius.electroero.domain.repository.RemoteDataSource
import com.delminius.electroero.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {
    suspend fun getAllBranchOffices(): Resource<BranchOffices> {
        return remoteDataSource.getAllBranchOffices()
    }

    suspend fun getPowerCutDataForSpecificDate(date: String): Resource<PowerCutOffice> {
        return remoteDataSource.getPowerCutDataForSpecificDate(date = date)
    }

    fun getAllBranches(): Flow<List<BranchOfficesItem>> {
        return localDataSource.getAllBranches()
    }

    suspend fun addToBranchSubscription(branchOfficesItem: BranchOfficesItem) {
        return localDataSource.addToBranchSubscription(branchOfficesItem = branchOfficesItem)
    }
}