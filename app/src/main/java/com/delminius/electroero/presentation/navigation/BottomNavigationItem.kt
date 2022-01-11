package com.delminius.electroero.presentation.navigation

import com.delminius.electroero.R

sealed class BottomNavigationItem(var route: String, var icon: Int, var title: String) {
    object HomeScreenItem : BottomNavigationItem(
        route = ApplicationScreens.HomeScreen.route,
        icon = R.drawable.ic_home,
        title = "Početna"
    )

    object BranchesScreenItem : BottomNavigationItem(
        route = ApplicationScreens.BranchesScreen.route,
        icon = R.drawable.ic_plug,
        title = "Poslovnice"
    )

    object SubscriptionsScreenItem : BottomNavigationItem(
        route = ApplicationScreens.SubscriptionScreen.route,
        icon = R.drawable.ic_bookmarks,
        title = "Pretplate"
    )
}