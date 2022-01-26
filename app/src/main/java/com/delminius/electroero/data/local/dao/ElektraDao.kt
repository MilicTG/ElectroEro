package com.delminius.electroero.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delminius.electroero.domain.model.BranchOfficesItem

@Dao
interface ElektraDao {

    @Query("SELECT * FROM elektra_database")
   suspend fun getAllBranches(): List<BranchOfficesItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToBranchSubscription(branchOfficesItem: BranchOfficesItem)
}