package com.delminius.electroero.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BranchOfficesItem(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)