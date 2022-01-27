package com.delminius.electroero.presentation.ui.screens.subscriptions

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delminius.electroero.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SubscriptionViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    private val _uiEvent = Channel<SubscriptionEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var getSubscriptionsJob: Job? = null

    private val _allBranchesSubscriptionState = mutableStateOf(SubscriptionState())
    val allBranchesSubscriptionState: State<SubscriptionState> = _allBranchesSubscriptionState


    init {
        getSubscriptionsJob?.cancel()
        getSubscriptionsJob =
            useCases.getAllElektraSubscriptionUseCase.invoke().onEach { office ->
                _allBranchesSubscriptionState.value = allBranchesSubscriptionState.value.copy(
                    subscribedBranches = office
                )
            }.launchIn(viewModelScope)
    }

    fun onEvent(event: SubscriptionEvent) {
        when (event) {
            is SubscriptionEvent.OnBranchInfoClicked -> {

            }

            is SubscriptionEvent.OnDeleteBranchClicked -> {
                sendUiEvent(event = event)
                viewModelScope.launch {
                    useCases.deleteSubscribedBranchUseCase(event.branchOfficesItem)
                }
            }
        }
    }

    private fun sendUiEvent(event: SubscriptionEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}