package com.example.criptoapp.data.remote

import com.example.criptoapp.data.remote.dto.CoinDto
import retrofit2.http.GET

interface CoinsApi {
    @GET("/Coins")
    suspend fun getCoins(): List<CoinDto>
}