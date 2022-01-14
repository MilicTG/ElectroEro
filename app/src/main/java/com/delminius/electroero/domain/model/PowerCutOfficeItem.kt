package com.delminius.electroero.domain.model

data class PowerCutOfficeItem(
    val branchOfficeId: Int,
    val branchOfficeName: String,
    val dateFrom: String,
    val dateTo: String,
    val id: Int,
    val location: String
)