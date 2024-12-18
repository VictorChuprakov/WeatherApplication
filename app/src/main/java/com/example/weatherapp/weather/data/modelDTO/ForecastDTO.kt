package com.example.weatherapp.weather.data.modelDTO

import kotlinx.serialization.Serializable

@Serializable
data class ForecastDTO(
    val forecastday: List<ForecastdayDTO>?=null
)