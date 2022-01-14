package com.delminius.electroero.presentation.ui.screens.container

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.delminius.electroero.presentation.navigation.SetupNavigation
import com.delminius.electroero.presentation.ui.components.BottomNavigationBar
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect


@Composable
@InternalCoroutinesApi
fun ContainerScreen(
    navController: NavHostController,
    containerViewModel: ContainerViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        containerViewModel.uiEvent.collect { event ->
            when (event) {
                is ContainerEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = event.action
                    )
                }
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        }
    ) {
        SetupNavigation(
            navController = navController,
            onSubscribeClicked = { content ->
                containerViewModel.onEvent(
                    ContainerEvent.ShowSnackBar(
                        message = content.snackMessage,
                        action = content.snackAction
                    )
                )
            }
        )
    }
}
