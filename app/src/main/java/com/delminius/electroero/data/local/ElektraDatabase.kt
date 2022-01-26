package com.delminius.electroero.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.delminius.electroero.data.local.dao.ElektraDao
import com.delminius.electroero.domain.model.BranchOfficesItem


@Database(entities = [BranchOfficesItem::class], version = 1)
abstract class ElektraDatabase : RoomDatabase() {
    abstract fun elektraDao(): ElektraDao
}