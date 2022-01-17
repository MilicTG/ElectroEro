package com.delminius.electroero.domain.repository

import com.delminius.electroero.domain.model.BranchOffices
import com.delminius.electroero.domain.model.PowerCutOffice
import com.delminius.electroero.util.Resource

interface RemoteDataSource {
   suspend fun getAllBranchOffices(): Resource<BranchOffices>
   suspend fun getPowerCutDataForSpecificDate(date: String): Resource<PowerCutOffice>
}