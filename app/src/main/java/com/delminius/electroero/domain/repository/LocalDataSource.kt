package com.delminius.electroero.domain.repository

import com.delminius.electroero.domain.model.BranchOfficesItem
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getAllBranches(): Flow<List<BranchOfficesItem>>
    suspend fun addToBranchSubscription(branchOfficesItem: BranchOfficesItem)
    suspend fun deleteSubscribedBranch(branchOfficesItem: BranchOfficesItem)
}