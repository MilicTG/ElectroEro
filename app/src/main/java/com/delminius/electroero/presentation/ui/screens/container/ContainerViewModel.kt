package com.delminius.electroero.presentation.ui.screens.container

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delminius.electroero.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContainerViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _uiEvent = Channel<ContainerEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: ContainerEvent) {
        when (event) {
            is ContainerEvent.ShowSnackBar -> {
                viewModelScope.launch {
                    _uiEvent.send(event)
                }
            }
            is ContainerEvent.TopAppBarAction -> {

            }

            is ContainerEvent.RefreshAction -> {

            }
        }
    }

}