package com.example.weatherapp.weather.data.modelDTO

import kotlinx.serialization.Serializable

@Serializable

data class AstroDTO(
    val moon_phase: String? = null,
    val moonrise: String? = null,
    val moonset: String? = null,
    val sunrise: String? = null,
    val sunset: String? = null,
)