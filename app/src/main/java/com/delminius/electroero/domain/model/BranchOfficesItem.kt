package com.delminius.electroero.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "branch_office")
data class BranchOfficesItem(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String
)