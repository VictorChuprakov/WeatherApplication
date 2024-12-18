package com.example.weatherapp.weather.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.weatherapp.weather.data.model.WeatherResponse

@Composable
fun CardAirQuality(weatherResponse: WeatherResponse) {
    val index = weatherResponse.current.air_quality.us_epa_index
    val airFraction = (index / 6f).coerceIn(0f, 1f)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.extraLarge)
            .background(Color(0x1A000000))
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "Индекс качества воздуха",
            color = Color(0xFFd2d6e1),
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = getEpaIndexLabel(index) + " (${weatherResponse.current.air_quality.us_epa_index})",
            color = Color(0xFFFFFFFF),
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center
        )
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .fillMaxWidth(0.8f)
                .height(12.dp)
                .background(Color(0x66DBDBDB))
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .fillMaxWidth(airFraction)
                    .height(12.dp)
                    .background(getAirQualityColor(index))
            )
        }
    }
}

fun getEpaIndexLabel(index: Int): String {
    return when (index) {
        1 -> "Хороший" // Good
        2 -> "Умеренный" // Moderate
        3 -> "Вреден для чувствительных групп" // Unhealthy for sensitive groups
        4 -> "Вреден" // Unhealthy
        5 -> "Очень вредный" // Very Unhealthy
        6 -> "Опасный" // Hazardous
        else -> "Неизвестный индекс" // Unknown Index
    }
}

fun getAirQualityColor(index: Int): Color {
    return when (index) {
        1 -> Color(0xFF0de414) // Зеленый: Хороший
        2 -> Color(0xFF0db700) // Светло-зеленый: Умеренный
        3 -> Color(0xFFfffd02) // Желтый: Умеренный
        4 -> Color(0xFFf5b700) // Оранжевый: Вреден для чувствительных групп
        5 -> Color(0xFFff7f00) // Темно-оранжевый: Вреден
        6 -> Color(0xFFB60000)  // Красный: Очень вредный
        else -> Color(0xFF660000) // Черный/Очень темный: Опасный
    }
}