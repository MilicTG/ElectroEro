package com.delminius.electroero.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class BranchOffice(
    val id: Int,
    val name: String
)