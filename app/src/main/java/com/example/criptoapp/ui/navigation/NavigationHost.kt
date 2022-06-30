package com.example.criptoapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.criptoapp.ui.screens.CoinListScreen
import com.example.criptoapp.ui.screens.RegisterCoinScreen

@Composable
fun NavigationHost() {
    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = Screens.CoinListScreen.route
    ) {
        composable(Screens.CoinListScreen.route){
            CoinListScreen(navHostController = navHostController)
        }
        composable(Screens.RegisterCoinScreen.route){
            RegisterCoinScreen(navHostController = navHostController)
        }
    }

}