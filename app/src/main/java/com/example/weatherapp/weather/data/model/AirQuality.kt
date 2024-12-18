package com.example.weatherapp.weather.data.model

import kotlinx.serialization.SerialName

data class AirQuality(
    @SerialName("us-epa-index")
    val us_epa_index: Int,
)