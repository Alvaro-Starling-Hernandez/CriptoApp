package com.example.criptoapp.ui.screens.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.criptoapp.data.remote.dto.CoinDto

@Composable
fun Image(coin: CoinDto) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(coin.imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = coin.descripcion,
        modifier = Modifier.clip(CircleShape)
    )
}