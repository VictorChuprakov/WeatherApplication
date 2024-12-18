package com.example.weatherapp.weather.data.modelDTO

import kotlinx.serialization.Serializable

@Serializable
data class CurrentDTO(
    val air_quality: AirQualityDTO ? = null,
    val condition: ConditionDTO? = null,
    val dewpoint_c: Double? = null,
    val dewpoint_f: Double? = null,
    val gust_kph: Double? = null,
    val gust_mph: Double? = null,
    val humidity: Int? = null,
    val pressure_in: Double? = null,
    val pressure_mb: Double? = null,
    val feelslike_c: Double? = null,
    val feelslike_f: Double? = null,
    val temp_c: Double? = null,
    val temp_f: Double? = null,
    val uv: Double? = null,
    val vis_km: Double? = null,
    val vis_miles: Double? = null,
    val wind_dir: String? = null,
    val wind_kph: Double? = null,
    val wind_mph: Double? = null,
)