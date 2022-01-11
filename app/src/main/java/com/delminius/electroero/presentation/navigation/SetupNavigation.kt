package com.delminius.electroero.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.delminius.electroero.presentation.ui.screens.BranchesScreen
import com.delminius.electroero.presentation.ui.screens.HomeScreen
import com.delminius.electroero.presentation.ui.screens.SubscriptionsScreen

@Composable
fun SetupNavigation(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = ApplicationScreens.HomeScreen.route
    ) {
        composable(ApplicationScreens.HomeScreen.route) {
            HomeScreen()
        }
        composable(ApplicationScreens.BranchesScreen.route) {
            BranchesScreen()
        }
        composable(ApplicationScreens.SubscriptionScreen.route) {
            SubscriptionsScreen()
        }
    }
}