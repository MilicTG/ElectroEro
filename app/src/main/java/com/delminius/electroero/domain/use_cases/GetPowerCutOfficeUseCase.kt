package com.delminius.electroero.domain.use_cases

import com.delminius.electroero.data.repository.Repository
import com.delminius.electroero.domain.model.PowerCutOffice
import com.delminius.electroero.util.Resource

class GetPowerCutOfficeUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(date: String): Resource<PowerCutOffice> {
        return repository.getPowerCutDataForSpecificDate(date = date)
    }
}