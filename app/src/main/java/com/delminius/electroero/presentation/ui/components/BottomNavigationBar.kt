package com.delminius.electroero.presentation.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.delminius.electroero.presentation.navigation.BottomNavigationItem

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val navigationItems = listOf(
        BottomNavigationItem.HomeScreenItem,
        BottomNavigationItem.BranchesScreenItem,
        BottomNavigationItem.SubscriptionsScreenItem
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        contentColor = MaterialTheme.colorScheme.background
    ) {
        navigationItems.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                icon = {
                    Icon(
                        painterResource(
                            id = screen.icon
                        ),
                        contentDescription = screen.title
                    )
                },
                label = {
                    Text(
                        text = screen.title,
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    selectedTextColor = MaterialTheme.colorScheme.onBackground,
                    unselectedIconColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                    unselectedTextColor =  MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                    indicatorColor = MaterialTheme.colorScheme.primary
                ),
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}