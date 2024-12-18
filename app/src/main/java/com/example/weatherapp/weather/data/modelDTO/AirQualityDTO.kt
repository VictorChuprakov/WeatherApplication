package com.example.weatherapp.weather.data.modelDTO

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AirQualityDTO(
    @SerialName("us-epa-index")
    val us_epa_index: Int? = null,
)