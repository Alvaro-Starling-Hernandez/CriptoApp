package com.example.criptoapp.ui.screens

import android.sax.RootElement
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.criptoapp.ui.navigation.Screens
import com.example.criptoapp.ui.screens.CoinViewModel
import com.example.criptoapp.ui.screens.components.CoinItem
import com.example.criptoapp.ui.screens.components.LoadingCards
import com.example.criptoapp.ui.theme.CriptoAppTheme
import com.valentinilk.shimmer.shimmer

@Composable
fun CoinListScreen(
    navHostController: NavHostController,
    viewModel: CoinViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val context = LocalContext.current

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Row(modifier = Modifier.padding(bottom = 4.dp)) {
                            Row {
                                Icon(
                                    Icons.Default.CurrencyExchange,
                                    contentDescription = null,
                                    modifier = Modifier.padding(start = 20.dp)
                                )
                                Text(
                                    text = "Description",
                                    modifier = Modifier.padding(start = 16.dp)
                                )
                            }
                            Text(
                                text = "Price (USD)",
                                modifier = Modifier.padding(start = 85.dp)
                            )
                        }
                    }
                }
            )
        },
        floatingActionButton = {

            FloatingActionButton(
                onClick = { navHostController.navigate(Screens.RegisterCoinScreen.route)}
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }

        },
        floatingActionButtonPosition = FabPosition.End


    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .absolutePadding(16.dp, 8.dp, 16.dp, 8.dp)
        ) {

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(state.coins) { coin ->
                    CoinItem(coin = coin, onClick = {})
                }
            }

            if (state.isLoading) {
                for(n in 1..15){
                    LoadingCards()
                }
            }


        }
    }
}