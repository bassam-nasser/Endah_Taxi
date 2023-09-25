package com.megatrust.endahtaxi.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.megatrust.endahtaxi.screens.home.HomeScreen
import com.megatrust.endahtaxi.screens.reg.RegisterScreen
import com.megatrust.endahtaxi.screens.reg.RegisterScreenContent

@Composable
fun EndahApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomeScreen") {
        composable("HomeScreen") { HomeScreen(navController) }
        composable("RegisterScreen") { RegisterScreen(navController) }
    }
}