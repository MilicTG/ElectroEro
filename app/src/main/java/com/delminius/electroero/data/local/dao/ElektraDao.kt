package com.delminius.electroero.data.local.dao

import androidx.room.*
import com.delminius.electroero.domain.model.BranchOfficesItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ElektraDao {

    @Query(value = "SELECT * FROM branch_office")
    fun getAllBranches(): Flow<List<BranchOfficesItem>>

    @Query(value = "SELECT * FROM branch_office")
    fun getAllBranchesForCompare(): List<BranchOfficesItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToBranchSubscription(branchOfficesItem: BranchOfficesItem)

    @Delete
    suspend fun deleteSubscribedBranch(branchOfficesItem: BranchOfficesItem)
}