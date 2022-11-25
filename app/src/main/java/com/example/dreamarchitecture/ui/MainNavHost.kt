package com.example.dreamarchitecture.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.home.HomeRoute
import com.example.navigation.Routes

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier,
) {
    NavHost(navController = navController, startDestination = Routes.Home, modifier = modifier) {
        composable(Routes.Home) {
            HomeRoute()
        }
    }
}