package com.example.weatherapp.weather.data.model

data class WeatherResponse(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)