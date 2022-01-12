package com.delminius.electroero.presentation.ui.screens.branches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delminius.electroero.domain.model.BranchOffices
import com.delminius.electroero.domain.use_cases.UseCases
import com.delminius.electroero.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BranchesViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _allBranchOfficesList = MutableStateFlow<Resource<BranchOffices>>(value = Resource.Loading())
    val allBranchOffices: StateFlow<Resource<BranchOffices>> = _allBranchOfficesList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _allBranchOfficesList.value = useCases.getAllBranchOfficesUseCase()
        }
    }

}