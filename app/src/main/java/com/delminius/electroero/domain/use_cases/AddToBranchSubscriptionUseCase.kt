package com.delminius.electroero.domain.use_cases

import com.delminius.electroero.data.repository.Repository
import com.delminius.electroero.domain.model.BranchOfficesItem

class AddToBranchSubscriptionUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(branchOfficesItem: BranchOfficesItem) {
        repository.addToBranchSubscription(branchOfficesItem = branchOfficesItem)
    }
}