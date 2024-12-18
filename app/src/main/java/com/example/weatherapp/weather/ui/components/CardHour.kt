package com.example.weatherapp.weather.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.weather.data.model.WeatherResponse
import com.example.weatherapp.weather.utils.ConverterWeatherIcon
import com.example.weatherapp.weather.utils.ConvertersWeather.extractTime
import com.example.weatherapp.weather.utils.ConvertersWeather.formatRainChange
import com.example.weatherapp.weather.utils.ConvertersWeather.formatTemperature
import com.example.weatherapp.weather.utils.ConvertersWeather.parseDataTimeToTime


@Composable
fun CardHour(weatherResponse: WeatherResponse) {
    val currentTime = parseDataTimeToTime(weatherResponse.location.localtime)
    val filteredHours =
        weatherResponse.forecast.forecastday[0].hour.filter { parseDataTimeToTime(it.time) >= currentTime } +
        weatherResponse.forecast.forecastday[1].hour.filter { parseDataTimeToTime(it.time) <= currentTime }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.extraLarge)
            .background(Color(0x1A000000))
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "${weatherResponse.current.condition.text}. Ощущается как ${weatherResponse.current.feelslike_c.formatTemperature()}",
            color = Color(0xFFFFFFFF),
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
        )
        HorizontalDivider(
            thickness = 0.5.dp,
            color = Color(0xFFd2d6e1)
        )
        LazyRow {
            items(filteredHours) { hour ->
                HourItem(
                    hour.time,
                    hour.condition.icon,
                    hour.temp_c,
                    hour.chance_of_rain
                )
            }
        }
    }
}


@Composable
private fun HourItem(
    time: String,
    icon: String,
    temperature: Double,
    rain: Int,
) {
    val weatherIcon = ConverterWeatherIcon(icon)
    val weatherTime = extractTime(time)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier.width(50.dp)
    ) {
        Text(
            text = weatherTime,
            color = Color(0xFFd2d6e1),
            style = MaterialTheme.typography.labelMedium.copy(
                letterSpacing = ((-0.3).sp),
                fontWeight = FontWeight.Normal
            )
        )
        Image(
            imageVector = ImageVector.vectorResource(weatherIcon),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(30.dp),
        )
        Text(
            text = temperature.formatTemperature(),
            color = Color(0xFFFFFFFF),
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_drop),
                contentDescription = null,
                modifier = Modifier.size(10.dp),
                tint =  Color(0xB3FFFFFF)
            )
            Text(
                text = rain.formatRainChange(),
                color =  Color(0xB3FFFFFF),
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }
}

