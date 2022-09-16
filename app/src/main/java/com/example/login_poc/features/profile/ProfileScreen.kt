package com.example.login_poc.features.profile

import InfoTemplate
import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.login_poc.features.bottomBarNavigation.BottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) {
        InfoTemplate(
            icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "profile") },
            title = { Text("Aba de Perfil") },
            description = { Text("Trabalho em progresso. Volte aqui mais tarde.") },
        )
    }
}