package com.example.criptoapp.ui.screens.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.criptoapp.data.remote.dto.CoinDto
import com.example.criptoapp.ui.theme.Eczar
import java.text.DecimalFormat

@Composable
fun CoinItem(
    coin: CoinDto,
    onClick: (CoinDto) -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 5.dp,
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 2.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier
            .clickable { onClick(coin) }
            .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Image(coin = coin)
                Spacer(modifier = Modifier.width(15.dp))
                Text(text = coin.descripcion)
            }
            val decimalFormat = DecimalFormat("#,###.######")
            Text(
                text = "$ " + decimalFormat.format(coin.valor.toDouble()),
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Normal,
                letterSpacing = 3.sp,
                fontFamily = Eczar
            )
        }

    }
}