package com.example.weatherapp.weather.data.modelDTO

import kotlinx.serialization.Serializable

@Serializable

data class DayDTO(
    val condition: ConditionDTO? = null,
    val daily_chance_of_rain: Int? = null,
    val maxtemp_c: Double? = null,
    val maxtemp_f: Double? = null,
    val mintemp_c: Double? = null,
    val mintemp_f: Double? = null,
)