package com.delminius.electroero.domain.use_cases

import com.delminius.electroero.data.repository.Repository
import com.delminius.electroero.domain.model.BranchOffices
import com.delminius.electroero.util.Resource

class GetAllBranchOfficesUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(): Resource<BranchOffices>{
        return repository.getAllBranchOffices()
    }
}