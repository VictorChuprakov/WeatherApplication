package com.example.weatherapp.shared.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.search.ui.SearchScreen
import com.example.weatherapp.settings.ui.SettingsScreen
import com.example.weatherapp.weather.ui.WeatherScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppDestinations.Main,
    ) {
        composable<AppDestinations.Main>{
            WeatherScreen(navController)
        }
        composable<AppDestinations.Settings>{
            SettingsScreen(navController)
        }
        composable<AppDestinations.Search>{
            SearchScreen(navController)
        }
    }
}