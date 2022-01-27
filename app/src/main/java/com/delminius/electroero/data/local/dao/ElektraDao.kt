package com.delminius.electroero.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delminius.electroero.domain.model.BranchOfficesItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ElektraDao {

    @Query("SELECT * FROM branch_office")
    fun getAllBranches(): Flow<List<BranchOfficesItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToBranchSubscription(branchOfficesItem: BranchOfficesItem)
}