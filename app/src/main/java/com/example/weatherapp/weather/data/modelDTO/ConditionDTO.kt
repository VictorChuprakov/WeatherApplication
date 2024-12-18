package com.example.weatherapp.weather.data.modelDTO

import kotlinx.serialization.Serializable

@Serializable

data class ConditionDTO(
    val icon: String? = null,
    val text: String? = null,
)