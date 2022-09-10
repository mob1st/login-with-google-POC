package com.example.login_poc.features.home

import InfoTemplate
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    InfoTemplate(
        icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "home") },
        title = { Text("Aba da Home") },
        description = { Text("Trabalho em progresso. Volte aqui mais tarde.") },
    )
}