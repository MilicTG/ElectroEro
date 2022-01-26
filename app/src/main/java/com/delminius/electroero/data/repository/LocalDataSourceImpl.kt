package com.delminius.electroero.data.repository

import com.delminius.electroero.data.local.ElektraDatabase
import com.delminius.electroero.domain.model.BranchOfficesItem
import com.delminius.electroero.domain.repository.LocalDataSource

class LocalDataSourceImpl(elektraDatabase: ElektraDatabase) : LocalDataSource {

    private val elektraDao = elektraDatabase.elektraDao()

    override suspend fun getAllBranches(): List<BranchOfficesItem> {
        return elektraDao.getAllBranches()
    }

    override suspend fun addToBranchSubscription(branchOfficesItem: BranchOfficesItem) {
        return elektraDao.addToBranchSubscription(branchOfficesItem = branchOfficesItem)
    }

}