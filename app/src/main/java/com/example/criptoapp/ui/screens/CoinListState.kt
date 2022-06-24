package com.example.criptoapp.ui.screens

import androidx.compose.runtime.Composable
import com.example.criptoapp.data.remote.dto.CoinDto

data class CoinListState(
    val isLoading: Boolean = false,
    val exchanges: List<CoinDto> = emptyList(),
    val error: String = ""
)
