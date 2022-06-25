package com.example.criptoapp.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun LoadingCards() {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 1.dp,
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(8.dp).height(25.dp)
        ) {
            ImageLoading()
            Spacer(modifier = Modifier.width(25.dp))
            Row {
                Box(
                    modifier = Modifier
                        .shimmer()
                        .width(150.dp)
                        .height(30.dp)
                        .padding(top = 8.dp)
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .height(30.dp)
                                .fillMaxWidth()
                                .width(50.dp)
                                .background(Color.Gray)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(60.dp))
                Box(
                    modifier = Modifier
                        .shimmer()
                        .width(50.dp)
                        .height(30.dp)
                        .padding(top = 8.dp)
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .height(30.dp)
                                .fillMaxWidth()
                                .width(50.dp)
                                .background(Color.Gray)
                        )
                    }
                }
            }

        }
    }
}