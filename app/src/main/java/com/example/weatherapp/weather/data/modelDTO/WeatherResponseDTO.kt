package com.example.weatherapp.weather.data.modelDTO

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponseDTO(
    val current: CurrentDTO? = null,
    val forecast: ForecastDTO? = null,
    val location: LocationDTO? = null
)