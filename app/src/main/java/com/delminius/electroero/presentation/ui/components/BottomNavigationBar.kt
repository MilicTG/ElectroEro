package com.delminius.electroero.presentation.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.delminius.electroero.presentation.navigation.BottomNavigationItem
import com.delminius.electroero.presentation.ui.theme.DarkBackgroundAndTextColor
import com.delminius.electroero.presentation.ui.theme.LightBackgroundAndTextColor

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

    BottomNavigation(
        backgroundColor = DarkBackgroundAndTextColor,
        contentColor = LightBackgroundAndTextColor
    ) {
        navigationItems.forEach { screen ->
            BottomNavigationItem(
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
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Gray,
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