package com.delminius.electroero.domain.use_cases

import com.delminius.electroero.data.repository.Repository
import com.delminius.electroero.domain.model.BranchOfficesItem
import kotlinx.coroutines.flow.Flow

class GetAllElektraSubscriptionUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<List<BranchOfficesItem>> {
        return repository.getAllBranches()
    }
}