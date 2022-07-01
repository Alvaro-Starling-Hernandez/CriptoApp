package com.example.criptoapp.ui.screens

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.criptoapp.data.remote.CoinsRepository
import com.example.criptoapp.data.remote.dto.CoinDto
import com.example.criptoapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(
    private val coinsRepository: CoinsRepository
) : ViewModel() {
    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state
    var message by mutableStateOf("")

    var name by mutableStateOf("")
    var price by mutableStateOf("")


    init {
        coinsRepository.getCoins().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinListState(error = result.message ?: "Error desconocido")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun setCoin() {
         viewModelScope.launch {
             coinsRepository.setCoin(
                CoinDto(
                    descripcion = name,
                    valor = price.toDouble()
                )
            )
        }
    }
}