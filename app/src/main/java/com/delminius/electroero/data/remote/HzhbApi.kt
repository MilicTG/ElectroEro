package com.delminius.electroero.data.remote

import com.delminius.electroero.domain.model.BranchOffice
import retrofit2.http.GET

interface HzhbApi {

    @GET(value= "/api/branchoffice")
    suspend fun getAllBranchOffices(): BranchOffice
}