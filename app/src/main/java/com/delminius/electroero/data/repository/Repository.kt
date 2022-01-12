package com.delminius.electroero.data.repository

import com.delminius.electroero.domain.model.BranchOffices
import com.delminius.electroero.util.Resource
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {

    suspend fun getAllBranchOffices(): Resource<BranchOffices> {
        return remoteDataSource.getAllBranchOffices()
    }
}