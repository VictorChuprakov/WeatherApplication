package com.example.weatherapp.weather.data.model

data class Current(
    val air_quality: AirQuality,
    val condition: Condition,
    val dewpoint_c: Double,
    val dewpoint_f: Double,
    val gust_kph: Double,
    val gust_mph: Double,
    val humidity: Int,
    val pressure_in: Double,
    val pressure_mb: Double,
    val feelslike_c: Double,
    val feelslike_f: Double,
    val temp_c: Double,
    val temp_f: Double,
    val uv: Double,
    val vis_km: Double,
    val vis_miles: Double,
    val wind_dir: String,
    val wind_kph: Double,
    val wind_mph: Double,
)