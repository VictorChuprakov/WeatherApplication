package com.example.weatherapp.shared.navigation

import kotlinx.serialization.Serializable

sealed class AppDestinations {
    @Serializable
    data object Main : AppDestinations()

    @Serializable
    data object Settings : AppDestinations()

    @Serializable
    data object Search : AppDestinations()
}