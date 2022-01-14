package com.delminius.electroero.util

sealed class UiEvent {
    data class ShowSnackBar(
        val message: String,
        val action: String? = null
    ) : UiEvent()
}
