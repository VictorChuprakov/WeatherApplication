package com.example.weatherapp.weather.data.model

data class Hour(
    val chance_of_rain: Int,
    val condition: Condition,
    val temp_c: Double,
    val temp_f: Double,
    val time: String,
)