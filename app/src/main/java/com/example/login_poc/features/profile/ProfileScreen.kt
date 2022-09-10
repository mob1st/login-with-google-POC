package com.example.login_poc.features.profile

import InfoTemplate
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController) {
    InfoTemplate(
        icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "profile") },
        title = { Text("Aba de Perfil") },
        description = { Text("Trabalho em progresso. Volte aqui mais tarde.") },
    )
}