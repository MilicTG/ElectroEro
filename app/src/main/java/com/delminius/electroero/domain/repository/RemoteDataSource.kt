package com.delminius.electroero.domain.repository

import com.delminius.electroero.domain.model.BranchOffice

interface RemoteDataSource {
   suspend fun getAllBranchOffices(): List<BranchOffice>
}