package com.delminius.electroero.presentation.ui.screens.branches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delminius.electroero.domain.model.BranchOffices
import com.delminius.electroero.domain.use_cases.UseCases
import com.delminius.electroero.util.Resource
import com.delminius.electroero.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BranchesViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _allBranchOfficesList =
        MutableStateFlow<Resource<BranchOffices>>(value = Resource.Loading())
    val allBranchOffices: StateFlow<Resource<BranchOffices>> = _allBranchOfficesList

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _allBranchOfficesList.value = useCases.getAllBranchOfficesUseCase()
        }
    }

    fun onEvent(event: BranchesEvent) {
        when (event) {
            is BranchesEvent.OnBranchInfoClicked -> {

            }
            is BranchesEvent.OnSubscribeClicked -> {
                sendUiEvent(
                    UiEvent.ShowSnackBar(
                        message = "Poslovnica dodana",
                        action = "Poništi"
                    )
                )
            }
            is BranchesEvent.OnCancelSubscribeClicked -> {

            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

}