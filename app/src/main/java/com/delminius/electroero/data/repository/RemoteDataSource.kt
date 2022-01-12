package com.delminius.electroero.data.repository

import com.delminius.electroero.domain.model.BranchOffices
import com.delminius.electroero.util.Resource

interface RemoteDataSource {
   suspend fun getAllBranchOffices(): Resource<BranchOffices>
}