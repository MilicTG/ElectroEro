package com.delminius.electroero.domain.use_cases

import com.delminius.electroero.data.repository.Repository
import com.delminius.electroero.domain.model.BranchOfficesItem

class GetAllBranchesForCompare(
    private val repository: Repository
) {
    operator fun invoke(): List<BranchOfficesItem> {
        return repository.getAllBranchesForCompare()
    }
}