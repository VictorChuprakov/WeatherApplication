package com.example.weatherapp.weather.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.weather.data.model.WeatherResponse
import com.example.weatherapp.weather.utils.ConvertersWeather.formatTemperature


@Composable
fun CardCurrent(weatherResponse: WeatherResponse) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = weatherResponse.current.temp_c.toInt().toString(),
            style = MaterialTheme.typography.displayLarge.copy(
                fontSize = 100.sp
            ),
            color = Color(0xFFFFFFFF),
        )
        Text(
            text = weatherResponse.current.condition.text,
            color = Color(0xFFFFFFFF),
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = "Высокая ${weatherResponse.forecast.forecastday[0].day.maxtemp_c.formatTemperature()}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFFFFFFFF),
                overflow = TextOverflow.Ellipsis
            )
            Box(
                modifier = Modifier
                    .size(5.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFFFFFF))
            )
            Text(
                text = "Низкая ${weatherResponse.forecast.forecastday[0].day.mintemp_c.formatTemperature()}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFFFFFFFF)
            )
        }
    }
}

@Composable
fun CardCurrent2(weatherResponse: WeatherResponse) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = weatherResponse.current.temp_c.toInt().toString(),
                style = MaterialTheme.typography.displayLarge,
                color = Color(0xFFFFFFFF),
            )
            Column {
                Text(
                    text = weatherResponse.current.condition.text,
                    color = Color(0xFFFFFFFF),
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(
                        text = "Высокая ${weatherResponse.forecast.forecastday[0].day.maxtemp_c.formatTemperature()}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFFFFFFFF),
                        overflow = TextOverflow.Ellipsis
                    )
                    Box(
                        modifier = Modifier
                            .size(5.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFFFFFFF))
                    )
                    Text(
                        text = "Низкая ${weatherResponse.forecast.forecastday[0].day.mintemp_c.formatTemperature()}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFFFFFFFF)
                    )
                }
            }
        }
        Image(
            painter = painterResource(R.drawable.ic_night),
            contentDescription = null
        )
    }
}

