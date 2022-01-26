package com.delminius.electroero.domain.repository

import com.delminius.electroero.domain.model.BranchOfficesItem

interface LocalDataSource {
    suspend fun getAllBranches(): List<BranchOfficesItem>
    suspend fun addToBranchSubscription(branchOfficesItem: BranchOfficesItem)
}