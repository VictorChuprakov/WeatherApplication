package com.example.weatherapp.weather.utils

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun getGradientForSunTime(sunrise: String, sunset: String, currentTime: String): Brush {
    val sunriseTime = ConvertersWeather.parseTimeAMPM(sunrise)
    val sunsetTime = ConvertersWeather.parseTimeAMPM(sunset)
    val currentTimeOnly = ConvertersWeather.parseDataTimeToTime(currentTime)

    return when {
        currentTimeOnly.isAfter(sunriseTime) && currentTimeOnly.isBefore(sunriseTime.plusMinutes(60)) -> { // Утро
            Brush.verticalGradient(
                listOf(
                    Color(0xFF4b4d7c),
                    Color(0xFF6a6d9e),
                    Color(0xFFf39e5c),
                    Color(0xFFf55f6b),
                )
            )
        }
        currentTimeOnly.isAfter(sunriseTime.plusMinutes(60)) && currentTimeOnly.isBefore(sunsetTime) -> { // День
            Brush.linearGradient(
                listOf(
                    Color(0xFF81b7b9),
                    Color(0xFF79b4bc),
                    Color(0xFF61a9c0),
                    Color(0xFF4896bd),
                    Color(0xFF4479aa),
                    Color(0xFF4a7ead),
                )
            )
        }
        currentTimeOnly.isAfter(sunsetTime) && currentTimeOnly.isBefore(sunsetTime.plusMinutes(120)) -> { // Вечер
            Brush.verticalGradient(
                listOf(
                    Color(0xFF4d4f88),
                    Color(0xFF635a93),
                    Color(0xFF916ea4),
                    Color(0xFFa9718e),
                    Color(0xFFb37480),
                )
            )
        }
        else -> { // Ночь
            Brush.verticalGradient(
                listOf(
                    Color(0xFF2f3a68),
                    Color(0xFF38406f),
                    Color(0xFF3d4876),
                    Color(0xFF4b5684),
                    Color(0xFF515d8f),
                )
            )
        }
    }
}

