package com.delminius.electroero.presentation.ui.screens.home

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

    private val firstPowerCutDay: LocalDate = Clock.System.todayAt(TimeZone.currentSystemDefault())
    private val secondPowerCutDay = firstPowerCutDay.plus(1, DateTimeUnit.DAY)
    private val thirdPowerCutDay = firstPowerCutDay.plus(2, DateTimeUnit.DAY)

    val firstDayText = getDateOrDayForSpecificDay(day = "firstDate")
    val secondDayText = getDateOrDayForSpecificDay(day = "secondDate")
    val thirdDayText = getDateOrDayForSpecificDay(day = "thirdDate")


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
        val currentDay: LocalDate = Clock.System.todayAt(TimeZone.currentSystemDefault())
    }

    fun getDataToLists() {
        viewModelScope.launch(Dispatchers.IO) {
            _firstDayPowerCutDayList.value =
                useCases.getPowerCutOfficeUseCase(date = firstPowerCutDay.toString())
            _secondDayPowerCutDayList.value =
                useCases.getPowerCutOfficeUseCase(date = secondPowerCutDay.toString())
            _thirdDayPowerCutDayList.value =
                useCases.getPowerCutOfficeUseCase(date = thirdPowerCutDay.toString())
        }
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnHomeInfoClicked -> {

            }
        }
    }
}