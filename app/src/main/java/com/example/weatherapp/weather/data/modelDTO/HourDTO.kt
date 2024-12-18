package com.example.weatherapp.weather.data.modelDTO

import kotlinx.serialization.Serializable

@Serializable

data class HourDTO(
    val chance_of_rain: Int? = null,
    val condition: ConditionDTO? = null,
    val temp_c: Double? = null,
    val temp_f: Double? = null,
    val time: String? = null,
)