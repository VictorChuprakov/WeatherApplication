package com.example.weatherapp.shared.data.api

import com.example.weatherapp.weather.data.modelDTO.WeatherResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("forecast.json")
    suspend fun getWeather(
        @Query("key") key: String,
        @Query("q") city: String,
        @Query("days") days: Int,
        @Query("aqi") aqi: String,
        @Query("alerts") alerts: String,
        @Query("lang") language: String
    ): Response<WeatherResponseDTO>
}