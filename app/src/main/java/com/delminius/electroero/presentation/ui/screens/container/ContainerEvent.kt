package com.delminius.electroero.presentation.ui.screens.container

sealed class ContainerEvent {
    data class ShowSnackBar(
        val message: String,
        val action: String? = null
    ) : ContainerEvent()

    data class TopAppBarAction(
        val title: String,
        val message: String
    ) : ContainerEvent()

    object RefreshAction : ContainerEvent()
}
