package com.example.weatherapp.weather.data.modelDTO

import kotlinx.serialization.Serializable

@Serializable
data class LocationDTO(
    val country: String? = null,
    val name: String? = null,
    val localtime: String? = null,
    val region: String? = null,
)