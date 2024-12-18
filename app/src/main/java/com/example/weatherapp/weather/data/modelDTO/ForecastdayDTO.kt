package com.example.weatherapp.weather.data.modelDTO

import kotlinx.serialization.Serializable

@Serializable
data class ForecastdayDTO(
    val astro: AstroDTO? = null,
    val date: String? = null,
    val day: DayDTO? = null,
    val hour: List<HourDTO>? = null
)