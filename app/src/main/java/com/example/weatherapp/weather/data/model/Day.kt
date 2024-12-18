package com.example.weatherapp.weather.data.model
import kotlinx.serialization.Serializable

data class Day(
    val condition: Condition,
    val daily_chance_of_rain: Int,
    val maxtemp_c: Double,
    val maxtemp_f: Double,
    val mintemp_c: Double,
    val mintemp_f: Double,
)