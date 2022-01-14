package com.delminius.electroero.data.remote

import com.delminius.electroero.domain.model.BranchOffices
import com.delminius.electroero.domain.model.PowerCutOffice
import retrofit2.http.GET
import retrofit2.http.Path

interface HzhbApi {

    @GET(value= "/api/branchoffice")
    suspend fun getAllBranchOffices(): BranchOffices

    @GET(value = "/api/powercut/date/{powerCutDate}/branchoffice/0")
    suspend fun getPowerCutDataForSpecificDate(
        @Path(value ="powerCutDate") date: String
    ): PowerCutOffice
}