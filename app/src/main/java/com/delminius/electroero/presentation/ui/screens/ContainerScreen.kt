package com.delminius.electroero.presentation.ui.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.delminius.electroero.presentation.navigation.SetupNavigation
import com.delminius.electroero.presentation.ui.components.BottomNavigationBar

@Composable
fun ContainerScreen(
    navController: NavHostController,
) {
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
