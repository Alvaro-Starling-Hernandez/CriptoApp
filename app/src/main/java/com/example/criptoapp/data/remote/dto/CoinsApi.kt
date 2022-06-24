package com.example.criptoapp.data.remote.dto

import retrofit2.http.GET

interface CoinsApi {
    @GET("/Coins")
    suspend fun getCoins(): List<CoinDto>
}