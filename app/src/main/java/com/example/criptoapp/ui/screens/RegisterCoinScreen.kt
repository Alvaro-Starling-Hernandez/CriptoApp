package com.example.criptoapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.criptoapp.ui.navigation.Screens
import com.example.criptoapp.ui.screens.components.TextObligatorio

@Composable
fun RegisterCoinScreen(
    navHostController: NavHostController,
    viewModel: CoinViewModel = hiltViewModel()
) {

    var nameError by rememberSaveable { mutableStateOf(false) }
    var priceError by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Register of Coins")
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "ArrowBack",
                        modifier = Modifier.clickable {
                            navHostController.navigate(Screens.CoinListScreen.route)
                        }
                    )
                }
            )
        }

    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .absolutePadding(16.dp, 16.dp, 16.dp, 16.dp)
        ) {

            OutlinedTextField(
                value = viewModel.name,
                onValueChange = {
                    viewModel.name = it
                    nameError = false
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Name")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.CurrencyExchange,
                        contentDescription = null
                    )
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    keyboardType = KeyboardType.Text
                ),
                isError = nameError
            )

            TextObligatorio(error = nameError)

            Spacer(modifier = Modifier.height(25.dp))

            OutlinedTextField(
                value = viewModel.price,
                onValueChange = {
                    viewModel.price = it
                    priceError = false
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Price")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.AttachMoney,
                        contentDescription = null
                    )
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    keyboardType = KeyboardType.Decimal
                ),
                isError = priceError
            )

            TextObligatorio(error = priceError)

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = {
                    nameError = viewModel.name.isBlank()
                    priceError = viewModel.price.isBlank()
                    if (!nameError && !priceError) {
                        if (viewModel.price.toDouble() > 0) {
                            viewModel.setCoin()
                            Toast.makeText(
                                context,
                                "Save",
                                Toast.LENGTH_SHORT
                            ).show()
                            navHostController.navigate(Screens.CoinListScreen.route)
                        } else {
                            Toast.makeText(
                                context,
                                "The price cannot be less than or equal to zero",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                },
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            ) {
                Text(text = "Save")
            }

        }
    }
}