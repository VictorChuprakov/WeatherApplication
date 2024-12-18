package com.example.weatherapp.weather.data.model
import kotlinx.serialization.Serializable

data class Condition(
    val icon: String,
    val text: String
)