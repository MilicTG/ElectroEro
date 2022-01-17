package com.delminius.electroero.data.repository

import com.delminius.electroero.data.remote.HzhbApi
import com.delminius.electroero.domain.model.BranchOffices
import com.delminius.electroero.domain.model.PowerCutOffice
import com.delminius.electroero.domain.repository.RemoteDataSource
import com.delminius.electroero.util.Resource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val hzhbApi: HzhbApi
) : RemoteDataSource {

    override suspend fun getAllBranchOffices(): Resource<BranchOffices> {
        val response = try {
            hzhbApi.getAllBranchOffices()
        } catch (e: HttpException) {
            return Resource.Error(message = e.localizedMessage ?: "Dogodila je se greška!")
        } catch (e:IOException){
            return Resource.Error(message =  "Dogodila je se greška u preuzimanju, molimo provjerite internet konekciju!")
        }
        return Resource.Success(response)
    }

    override suspend fun getPowerCutDataForSpecificDate(date: String): Resource<PowerCutOffice> {
        val response = try {
            hzhbApi.getPowerCutDataForSpecificDate(date = date)
        } catch (e: HttpException) {
            return Resource.Error(message = e.localizedMessage ?: "Dogodila je se greška!")
        } catch (e:IOException){
            return Resource.Error(message =  "Dogodila je se greška u preuzimanju, molimo provjerite internet konekciju!")
        }
        return Resource.Success(response)
    }

}