package com.delminius.electroero.presentation.ui.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delminius.electroero.domain.model.PowerCutOffice
import com.delminius.electroero.domain.use_cases.UseCases
import com.delminius.electroero.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _currentPowerCutDayList =
        MutableStateFlow<Resource<PowerCutOffice>>(value = Resource.Loading())
    val currentPowerCutDayList: StateFlow<Resource<PowerCutOffice>> = _currentPowerCutDayList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _currentPowerCutDayList.value = useCases.getPowerCutOfficeUseCase(date = "2022-1-16")
        }
        Log.d("ovde",currentPowerCutDayList.value.toString() )
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnHomeInfoClicked -> {

            }
        }
    }
}