package com.example.weatherapp.weather.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.weather.data.model.WeatherResponse
import com.example.weatherapp.weather.utils.ConverterWeatherIcon
import com.example.weatherapp.weather.utils.ConvertersWeather.formatRainChange
import com.example.weatherapp.weather.utils.ConvertersWeather.formatTemperature
import com.example.weatherapp.weather.utils.ConvertersWeather.getDayOfWeek


@Composable
fun CardDay(weatherResponse: WeatherResponse) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.extraLarge)
            .background(Color(0x1A000000))
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        weatherResponse.forecast.forecastday.map { day ->
            DayItem(
                day.date,
                day.day.daily_chance_of_rain,
                day.day.condition.icon,
                day.day.maxtemp_c,
                day.day.mintemp_c,
            )
        }
    }
}

@Composable
private fun DayItem(
    date: String,
    rain: Int,
    icon: String,
    maxTemperature: Double,
    minTemperature: Double,
) {
    val weatherIcon = ConverterWeatherIcon(icon)
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = getDayOfWeek(date).replaceFirstChar { it.uppercase() },
            color = Color(0xFFFFFFFF),
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.weight(0.6f)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_drop),
                    contentDescription = null,
                    modifier = Modifier.size(10.dp),
                    tint = Color(0xB3FFFFFF),
                )
                Text(
                    text = rain.formatRainChange(),
                    color = Color(0xB3FFFFFF),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            AsyncImage(
                model = weatherIcon,
                contentDescription = null,
                modifier = Modifier.size(30.dp),
                contentScale = ContentScale.Crop,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.weight(1f)

            ) {
                Text(
                    text = maxTemperature.formatTemperature(),
                    color = Color(0xFFFFFFFF),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Black)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = minTemperature.formatTemperature(),
                    color = Color(0xFFFFFFFF),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Black)
                )
            }
        }
    }
}

