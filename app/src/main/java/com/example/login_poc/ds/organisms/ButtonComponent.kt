package com.example.login_poc.ds.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddButtonComponent() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { },
            modifier = Modifier.height(30.dp).width(40.dp),
            contentPadding = PaddingValues(3.dp),
            colors = ButtonDefaults.textButtonColors(
                contentColor = Color.White,
                containerColor = Color.Red,
            ),
            shape = RoundedCornerShape(5.dp)
        ) {
            Icon(
                Icons.Default.Add , contentDescription = "AddButton", tint = Color.White,
                modifier = Modifier.size(50.dp)
            )
        }
    }
}

@Composable
fun RemoveButtonComponent() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { },
            modifier = Modifier.height(30.dp).width(40.dp),
            contentPadding = PaddingValues(3.dp),
            colors = ButtonDefaults.textButtonColors(
                contentColor = Color.White,
                containerColor = Color.Red,
            ),
            shape = RoundedCornerShape(5.dp)
        ) {
            Icon(
                Icons.Default.Remove , contentDescription = "AddButton", tint = Color.White,
                modifier = Modifier.size(50.dp)
            )
        }
    }
}

@Preview
@Composable
fun CardTemplatePreview() {
    AddButtonComponent()
}