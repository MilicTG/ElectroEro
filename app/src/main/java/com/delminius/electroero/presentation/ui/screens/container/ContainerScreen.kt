package com.delminius.electroero.presentation.ui.screens.container

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.delminius.electroero.presentation.navigation.ApplicationScreens
import com.delminius.electroero.presentation.navigation.SetupNavigation
import com.delminius.electroero.presentation.ui.components.AppHomeTopBar
import com.delminius.electroero.presentation.ui.components.AppTopBar
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
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var isRefreshing by remember { (mutableStateOf(value = false)) }

    LaunchedEffect(key1 = true) {
        containerViewModel.uiEvent.collect { event ->
            when (event) {
                is ContainerEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = event.action
                    )
                }
                is ContainerEvent.RefreshAction -> {
                    isRefreshing = true
                }
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            when (navBackStackEntry?.destination?.route) {
                ApplicationScreens.HomeScreen.route -> {
                    AppHomeTopBar(
                        title = "Planirani radovi",
                        onRefreshClicked = {
                            containerViewModel.onEvent(
                                ContainerEvent.RefreshAction
                            )
                        },
                        onInfoClicked = {
                            containerViewModel.onEvent(
                                ContainerEvent.TopAppBarAction(
                                    title = "",
                                    message = ""
                                )
                            )
                        }
                    )
                }
                ApplicationScreens.BranchesScreen.route -> {
                    AppTopBar(
                        title = "Poslovnice",
                        onInfoClicked = {
                            containerViewModel.onEvent(
                                ContainerEvent.TopAppBarAction(
                                    title = "",
                                    message = ""
                                )
                            )
                        }
                    )
                }
                ApplicationScreens.SubscriptionScreen.route -> {
                    AppTopBar(
                        title = "Pretplate",
                        onInfoClicked = {
                            containerViewModel.onEvent(
                                ContainerEvent.TopAppBarAction(
                                    title = "",
                                    message = ""
                                )
                            )
                        }
                    )
                }
            }
        },
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
            },
            isRefreshing = isRefreshing,
            stopRefreshing = { isRefreshing = false }
        )
    }
}
