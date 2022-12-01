package com.example.login_poc.ds.organisms

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CardComponent(
    recipeName: String,
    image: String,
    onClick: Unit
) {
    OutlinedCard(
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(Color.Black),
        shape = RectangleShape,

        ) {
        CardImage(image)
        Text(
            recipeName,
            color = Color.White,
            modifier = Modifier.background(Color.Black)//Should be white
        )
    }
}

@Composable
fun CardImage(
    image: String
) {
    Card(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth(),
        shape = RectangleShape
    ) {
        Image(
            painter = rememberAsyncImagePainter(image),
            contentDescription = "Food image",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
fun CardComponentPreview() {
    CardComponent("", "", Unit)
}