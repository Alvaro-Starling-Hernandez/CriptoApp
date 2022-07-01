package com.example.criptoapp.data.remote

import com.example.criptoapp.data.remote.dto.CoinDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CoinsApi {
    @GET("/Coins")
    suspend fun getCoins(): List<CoinDto>

    @POST("/Coins")
    suspend fun setCoin(@Body coin: CoinDto): Response<CoinDto>
}