package com.example.criptoapp.data.remote

import com.example.criptoapp.data.remote.dto.CoinDto
import com.example.criptoapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinsRepository @Inject constructor(
    private val api: CoinsApi
){
    fun getCoins(): Flow<Resource<List<CoinDto>>> = flow {
        try {
            emit(Resource.Loading())

            val coins = api.getCoins()

            emit(Resource.Success(coins))

        } catch (e: HttpException) {
            emit(Resource.Error(e.message ?: "Error HTTP general"))
        } catch (e: IOException) {
            emit(Resource.Error(e.message ?: "Verificar la conexion a internet"))
        }
    }
}