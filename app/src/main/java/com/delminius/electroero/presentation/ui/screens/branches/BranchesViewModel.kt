package com.delminius.electroero.presentation.ui.screens.branches

import androidx.lifecycle.ViewModel
import com.delminius.electroero.domain.use_cases.UseCases
import com.delminius.electroero.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BranchesViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    suspend fun getAllBranchOffices(): Resource<BranchOffices> {
        return useCases.getAllBranchOfficesUseCase()
    }

}