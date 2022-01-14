package com.delminius.electroero.presentation.ui.screens.container

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.delminius.electroero.presentation.navigation.SetupNavigation
import com.delminius.electroero.presentation.ui.components.BottomNavigationBar

@Composable
fun ContainerScreen(
    navController: NavHostController,
) {
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true ){

    }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        }
    ) {
        SetupNavigation(
            navController = navController
        )
    }
}
