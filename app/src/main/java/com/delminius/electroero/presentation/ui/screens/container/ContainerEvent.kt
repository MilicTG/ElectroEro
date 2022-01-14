package com.delminius.electroero.presentation.ui.screens.container

sealed class ContainerEvent{
    data class ShowSnackBar(
        val message: String,
        val action: String? = null
    ): ContainerEvent()
}
