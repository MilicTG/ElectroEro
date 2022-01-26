package com.delminius.electroero.domain.use_cases

data class UseCases(
    val getAllBranchOfficesUseCase: GetAllBranchOfficesUseCase,
    val getPowerCutOfficeUseCase: GetPowerCutOfficeUseCase,
    val getAllElektraSubscriptionUseCase: GetAllElektraSubscriptionUseCase,
    val addToBranchSubscriptionUseCase: AddToBranchSubscriptionUseCase
)
