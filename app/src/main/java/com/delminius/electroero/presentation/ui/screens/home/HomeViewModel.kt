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
import kotlinx.datetime.*
import kotlinx.datetime.TimeZone
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    val today: LocalDate = Clock.System.todayAt(TimeZone.currentSystemDefault())
    val tomorrow = today.plus(1, DateTimeUnit.DAY)
    val dayThree =  today.plus(2, DateTimeUnit.DAY)
    private val currentDate = Date()


    val formatter = SimpleDateFormat("d.MM.yyyy")
    val formatToday = formatter.parse(currentDate.toString())


    private val _currentPowerCutDayList =
        MutableStateFlow<Resource<PowerCutOffice>>(value = Resource.Loading())
    val currentPowerCutDayList: StateFlow<Resource<PowerCutOffice>> = _currentPowerCutDayList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _currentPowerCutDayList.value = useCases.getPowerCutOfficeUseCase(date =dayThree.toString())
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