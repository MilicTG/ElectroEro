package com.delminius.electroero.domain.use_cases

import com.delminius.electroero.data.repository.Repository
import com.delminius.electroero.domain.model.BranchOfficesItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAllElektraSubscriptionUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(): Flow<List<BranchOfficesItem>> {
        return flow {
            repository.getAllBranches()
        }
    }
}