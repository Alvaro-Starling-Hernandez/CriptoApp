package com.example.criptoapp.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun ImageLoading() {
    Box(
        modifier = Modifier
            .shimmer()
            .clip(RoundedCornerShape(50.dp))
    ) {
        Box(
            modifier = Modifier
                .size(35.dp)
                .background(Color.Gray)
        )
    }
}