package com.delminius.electroero.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.delminius.electroero.presentation.ui.screens.ContainerScreen
import com.delminius.electroero.presentation.ui.theme.ElectroEroTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ElectroEroTheme {
                val navController = rememberNavController()
                ContainerScreen(
                    navController = navController
                )
            }
        }
    }
}
