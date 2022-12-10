package com.example.login_poc.ds.organisms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardComponent(
    recipeName: String,
    image: String,
    onClick: () -> Unit
) {
    OutlinedCard(
        onClick = { onClick() },
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth()
            .background(Color.Black),
        shape = RectangleShape,
        ) {
        Row() {
            Column() {
                CardImage(image)
            }

            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 20.dp, end = 20.dp)
            ) {
                CardText(recipeName)
            }
        }
    }
}

@Composable
fun CardImage(
    image: String
) {
    Card(
        modifier = Modifier
            .fillMaxHeight()
            .width(155.dp)
            .padding(start = 20.dp, top = 20.dp, bottom = 20.dp)
            .background(Color.White),
        shape = RoundedCornerShape(5)
    ) {
        Image(
            painter = rememberAsyncImagePainter(image),
            contentDescription = "Food image",
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        )
    }
}

@Composable
fun CardText(
    title: String
) {
    OutlinedCard(
        modifier = Modifier
            .fillMaxHeight()
            .width(200.dp)
            .padding(top = 20.dp, bottom = 20.dp)
            .background(Color.Blue)
        ,
        shape = RectangleShape
    ) {
        ProvideTextStyle(value = MaterialTheme.typography.titleMedium) {
            Text(title, color = Color.Gray, modifier = Modifier.padding(10.dp))
        }
    }
}

//@Preview
//@Composable
//fun CardComponentPreview() {
//    CardComponent(
//        "Brown Rice, and Vegetable Fried Rice",
//        "https://spoonacular.com/recipeImages/715594-312x231.jpg"
//    ) { (Unit) }
//}