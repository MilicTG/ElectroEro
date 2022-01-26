package com.delminius.electroero.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.delminius.electroero.util.Constants.ELEKTRA_DATABASE

@Entity(tableName = ELEKTRA_DATABASE)
data class BranchOfficesItem(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String
)