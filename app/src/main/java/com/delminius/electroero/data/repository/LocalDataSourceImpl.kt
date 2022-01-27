package com.delminius.electroero.data.repository

import com.delminius.electroero.data.local.dao.ElektraDao
import com.delminius.electroero.domain.model.BranchOfficesItem
import com.delminius.electroero.domain.repository.LocalDataSource
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(private val elektraDao: ElektraDao) : LocalDataSource {

    override fun getAllBranches(): Flow<List<BranchOfficesItem>> {
        return elektraDao.getAllBranches()
    }

    override suspend fun addToBranchSubscription(branchOfficesItem: BranchOfficesItem) {
        return elektraDao.addToBranchSubscription(branchOfficesItem = branchOfficesItem)
    }

    override suspend fun deleteSubscribedBranch(branchOfficesItem: BranchOfficesItem) {
        return elektraDao.deleteSubscribedBranch(branchOfficesItem = branchOfficesItem)
    }

}