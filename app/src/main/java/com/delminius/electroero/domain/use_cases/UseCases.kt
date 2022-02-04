package com.delminius.electroero.domain.use_cases

data class UseCases(
    val getAllBranchOfficesUseCase: GetAllBranchOfficesUseCase,
    val getAllBranchesForCompare: GetAllBranchesForCompare,
    val getPowerCutOfficeUseCase: GetPowerCutOfficeUseCase,
    val getAllElektraSubscriptionUseCase: GetAllElektraSubscriptionUseCase,
    val addToBranchSubscriptionUseCase: AddToBranchSubscriptionUseCase,
    val deleteSubscribedBranchUseCase: DeleteSubscribedBranchUseCase
)
