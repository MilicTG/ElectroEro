package com.delminius.electroero.presentation.ui.screens.subscriptions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delminius.electroero.domain.model.BranchOfficesItem
import com.delminius.electroero.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SubscriptionViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _allBranchesSubscription: MutableStateFlow<Flow<List<BranchOfficesItem>>> =
        MutableStateFlow(
           flow { emptyList<BranchOfficesItem>() }
        )
    val allBranchesSubscription: StateFlow<Flow<List<BranchOfficesItem>>> = _allBranchesSubscription

    init {
        viewModelScope.launch{
            _allBranchesSubscription.value = useCases.getAllElektraSubscriptionUseCase.invoke()
        }
    }
}