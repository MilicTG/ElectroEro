package com.delminius.electroero.presentation.ui.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delminius.electroero.domain.model.PowerCutOffice
import com.delminius.electroero.domain.use_cases.UseCases
import com.delminius.electroero.util.Resource
import com.delminius.electroero.util.getDateOrDayForSpecificDay
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.*
import kotlinx.datetime.TimeZone

import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {
    val firstDayText: MutableState<String> = mutableStateOf(value = "")
    val secondDayText: MutableState<String> = mutableStateOf(value = "")
    val thirdDayText: MutableState<String> = mutableStateOf(value = "")


    private val _firstDayPowerCutDayList =
        MutableStateFlow<Resource<PowerCutOffice>>(value = Resource.Loading())
    val firstDayPowerCutDayList: StateFlow<Resource<PowerCutOffice>> = _firstDayPowerCutDayList

    private val _secondDayPowerCutDayList =
        MutableStateFlow<Resource<PowerCutOffice>>(value = Resource.Loading())
    val secondDayPowerCutDayList: StateFlow<Resource<PowerCutOffice>> = _secondDayPowerCutDayList

    private val _thirdDayPowerCutDayList =
        MutableStateFlow<Resource<PowerCutOffice>>(value = Resource.Loading())
    val thirdDayPowerCutDayList: StateFlow<Resource<PowerCutOffice>> = _thirdDayPowerCutDayList

    init {
        getDatesForDays()
        getDataToLists()
    }

    private fun getDatesForDays() {
        firstDayText.value = getDateOrDayForSpecificDay(day = "firstDate")
        secondDayText.value = getDateOrDayForSpecificDay(day = "secondDate")
        thirdDayText.value = getDateOrDayForSpecificDay(day = "thirdDate")
    }

    private fun getDataToLists() {
        val firstPowerCutDay: LocalDate = Clock.System.todayAt(TimeZone.currentSystemDefault())
        val secondPowerCutDay = firstPowerCutDay.plus(1, DateTimeUnit.DAY)
        val thirdPowerCutDay = firstPowerCutDay.plus(2, DateTimeUnit.DAY)

        viewModelScope.launch(Dispatchers.IO) {
            _firstDayPowerCutDayList.value =
                useCases.getPowerCutOfficeUseCase(date = firstPowerCutDay.toString())
            _secondDayPowerCutDayList.value =
                useCases.getPowerCutOfficeUseCase(date = secondPowerCutDay.toString())
            _thirdDayPowerCutDayList.value =
                useCases.getPowerCutOfficeUseCase(date = thirdPowerCutDay.toString())
        }
    }

    fun refreshDataForPowerOutages() {
        getDatesForDays()
        getDataToLists()
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnHomeInfoClicked -> {

            }
        }
    }
}