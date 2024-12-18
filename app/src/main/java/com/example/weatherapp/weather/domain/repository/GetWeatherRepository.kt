package com.example.weatherapp.weather.domain.repository

import com.example.weatherapp.shared.data.api.State
import com.example.weatherapp.weather.data.model.WeatherResponse

interface GetWeatherRepository {
    suspend fun getWeather(): State<WeatherResponse>
}