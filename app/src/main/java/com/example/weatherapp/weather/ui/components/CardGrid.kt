package com.example.weatherapp.weather.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.weather.data.model.WeatherResponse
import com.example.weatherapp.weather.utils.ConvertersWeather.convertUVIndex
import com.example.weatherapp.weather.utils.ConvertersWeather.formatPressure
import com.example.weatherapp.weather.utils.ConvertersWeather.formatRainChange
import com.example.weatherapp.weather.utils.ConvertersWeather.formatTemperature
import com.example.weatherapp.weather.utils.ConvertersWeather.formatVisibility
import com.example.weatherapp.weather.utils.ConvertersWeather.formatWindSpeed

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CardGrid(weatherResponse: WeatherResponse) {
    val cardWeather = listOf(
        WeatherCardMini(
            icon = R.drawable.ic_uv_index,
            header = "УФ-индекс",
            title = convertUVIndex(weatherResponse.current.uv)
        ),
        WeatherCardMini(
            icon = R.drawable.ic_humidity,
            header = "Влажность",
            title = weatherResponse.current.humidity.formatRainChange()
        ),
        WeatherCardMini(
            icon = R.drawable.ic_wind,
            header = "Ветер",
            title = weatherResponse.current.wind_kph.formatWindSpeed()
        ),
        WeatherCardMini(
            icon = R.drawable.ic_dew_point,
            header = "Точка росы",
            title = weatherResponse.current.dewpoint_c.formatTemperature()
        ),
        WeatherCardMini(
            icon = R.drawable.ic_pressure,
            header = "Давление",
            title = weatherResponse.current.pressure_mb.formatPressure()
        ),
        WeatherCardMini(
            icon = R.drawable.ic_visibility,
            header = "Видимость",
            title = weatherResponse.current.vis_km.formatVisibility()
        ),
    )
    FlowRow(
        modifier = Modifier.fillMaxSize(),
        maxItemsInEachRow = 3,
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        cardWeather.forEach { card ->
            CardMini(
                weatherCardMini = card,
            )
        }
    }
}

@Composable
private fun CardMini(weatherCardMini: WeatherCardMini) {
    Column(
        modifier = Modifier
            .fillMaxWidth(0.48f)
            .height(100.dp)
            .clip(MaterialTheme.shapes.extraLarge)
            .background(Color(0x1A000000))
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(weatherCardMini.icon),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = Color(0xFFd2d6e1)
            )
            Text(
                text = weatherCardMini.header,
                color = Color(0xFFd2d6e1),
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Text(
            text = weatherCardMini.title,
            color = Color(0xFFFFFFFF),
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.W600),
            overflow = TextOverflow.Ellipsis,
        )
    }
}

private data class WeatherCardMini(
    val icon: Int,
    val header: String,
    val title: String,
)
