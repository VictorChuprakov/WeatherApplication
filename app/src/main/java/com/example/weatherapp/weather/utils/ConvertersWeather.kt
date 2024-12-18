package com.example.weatherapp.weather.utils

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

object ConvertersWeather {
    fun getDayOfWeek(dateString: String): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = LocalDate.parse(dateString, formatter)
        return date.dayOfWeek.getDisplayName(TextStyle.FULL, Locale("ru", "RU"))
    }

    fun convertUVIndex(uvIndex: Double): String {
        return when (uvIndex) {
            in 0.0..2.0 -> "Низкий"
            in 3.0..5.0 -> "Средний"
            in 6.0..7.0 -> "Высокий"
            in 8.0..10.0 -> "Очень высокий"
            else -> "Экстремальный"
        }
    }
    fun convertMoonPhase(phase: String): String {
        return when (phase) {
            "New Moon" -> "Новолуние"
            "Waxing Crescent" -> "Молодая луна"
            "First Quarter" -> "Первая четверть"
            "Waxing Gibbous" -> "Прибывающая луна"
            "Full Moon" -> "Полнолуние"
            "Waning Gibbous" -> "Убывающая луна"
            "Last Quarter" -> "Последняя четверть"
            "Waning Crescent" -> "Старая луна"
            else -> "Неизвестная фаза"
        }
    }

    fun extractTime(dateTime: String): String {
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val outputFormatter = DateTimeFormatter.ofPattern("HH:mm")
        val parsedDate = LocalDateTime.parse(dateTime, inputFormatter)
        return parsedDate.format(outputFormatter)
    }


    fun Double.formatTemperature(): String {
        return "${this.toInt()}" + "\u00B0"
    }

    fun Int.formatRainChange(): String {
        return "$this\u0025"
    }

    fun Double.formatVisibility(): String {
        return "${this.toInt()} км"
    }

    fun Double.formatPressure(): String {
        return "$this мбар"
    }

    fun Double.formatWindSpeed(): String {
        return "${this.toInt()} км/ч"
    }

    fun parseTimeAMPM(time: String): LocalTime {
        val timeFormatter = DateTimeFormatter.ofPattern("hh:mm a")
        return LocalTime.parse(time, timeFormatter)
    }

    fun parseDataTimeToTime(currentTime: String): LocalTime {
        val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        return LocalTime.parse(currentTime, dateTimeFormatter)
    }

    fun formatTimeAstro(time: String): String {
        val timeFormatter = DateTimeFormatter.ofPattern("hh:mm a")
        val parsedTime = LocalTime.parse(time, timeFormatter)
        val outputFormatter = DateTimeFormatter.ofPattern("HH:mm")
        return parsedTime.format(outputFormatter)
    }


    fun calculateSunProgress(sunrise: LocalTime, sunset: LocalTime, currentTime: LocalTime): Float {
        val totalMinutesInDay = java.time.Duration.between(sunrise, sunset).toMinutes()
        val minutesSinceSunrise = java.time.Duration.between(sunrise, currentTime).toMinutes()
        return (minutesSinceSunrise.toFloat() / totalMinutesInDay.toFloat()).coerceIn(0f, 1f)
    }
}