package com.delminius.electroero.data.repository

import android.util.Log
import com.delminius.electroero.data.remote.HzhbApi
import com.delminius.electroero.domain.model.BranchOffices
import com.delminius.electroero.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class RemoteDataSourceImpl @Inject constructor(
    private val hzhbApi: HzhbApi
) : RemoteDataSource {

    override suspend fun getAllBranchOffices(): Resource<BranchOffices> {
        val response = try {
            hzhbApi.getAllBranchOffices()
        } catch (e: Exception) {
            Log.d("ovde", e.toString())
            return Resource.Error(message = "Dogodila je se greška u preuzimanju.")
        }
        return Resource.Success(response)
    }

}