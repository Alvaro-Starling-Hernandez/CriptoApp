package com.example.criptoapp.ui.navigation

sealed class Screens (val route: String){
    object CoinListScreen: Screens("CoinListScreen")
    object RegisterCoinScreen: Screens("RegisterCoinScreen")
}