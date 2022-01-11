package com.delminius.electroero.presentation.navigation

sealed class ApplicationScreens(val route: String) {
    object HomeScreen : ApplicationScreens(route = "home_screen")
    object BranchesScreen : ApplicationScreens(route = "branches_screen")
    object SubscriptionScreen : ApplicationScreens(route = "subscription_screen")
}