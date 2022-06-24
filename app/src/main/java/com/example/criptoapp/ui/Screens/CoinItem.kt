package com.example.criptoapp.ui.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.criptoapp.data.remote.dto.CoinDto

@Composable
fun CoinItem(
    coin: CoinDto,
    onClick: (CoinDto) -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 1.dp,
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth(),
    ) {
        Row(modifier = Modifier
            .clickable { onClick(coin) }
            .padding(8.dp)
        ) {
//            Image(
//                modifier = Modifier.size(50.dp),
//                painter = rememberImagePainter(
//                    data = user.thumbnail,
//                    builder = {
//                        placeholder(R.drawable.placeholder)
//                        error(R.drawable.placeholder)
//                    }
//                ),
//                contentDescription = null,
//                contentScale = ContentScale.FillHeight
//            )
            //Spacer(modifier = Modifier.width(100.dp))

            Text(coin.description)

            Spacer(modifier = Modifier.width(100.dp))

            Text(text = coin.valor)
        }

    }
}