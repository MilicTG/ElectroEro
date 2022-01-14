package com.delminius.electroero.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.delminius.electroero.domain.model.SnackBarContent
import com.delminius.electroero.presentation.ui.screens.branches.BranchesScreen
import com.delminius.electroero.presentation.ui.screens.HomeScreen
import com.delminius.electroero.presentation.ui.screens.SubscriptionsScreen

@Composable
fun SetupNavigation(
    navController: NavHostController,
    onSubscribeClicked: (SnackBarContent) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = ApplicationScreens.HomeScreen.route
    ) {
        composable(ApplicationScreens.HomeScreen.route) {
            HomeScreen()
        }
        composable(ApplicationScreens.BranchesScreen.route) {
            BranchesScreen(
                onSubscribeClicked = onSubscribeClicked
            )
        }
        composable(ApplicationScreens.SubscriptionScreen.route) {
            SubscriptionsScreen()
        }
    }
}