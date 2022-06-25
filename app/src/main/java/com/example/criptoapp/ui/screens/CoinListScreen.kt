package com.example.criptoapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CurrencyBitcoin
import androidx.compose.material.icons.filled.CurrencyExchange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.example.criptoapp.ui.screens.CoinViewModel
import com.example.criptoapp.ui.screens.components.CoinItem

@Composable
fun CoinListScreen(
    viewModel: CoinViewModel = hiltViewModel()
) {
    val state = viewModel.state.value


    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(text = "CryptoApp",
                    fontFamily = FontFamily.Serif)
                }
            )
        }

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .absolutePadding(16.dp, 16.dp, 16.dp, 16.dp)
        ) {

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(state.coins) { coin ->
                    CoinItem(coin = coin, onClick = {})
                }
            }

            if (state.isLoading) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}