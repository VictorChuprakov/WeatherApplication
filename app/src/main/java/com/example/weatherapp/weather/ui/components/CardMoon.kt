package com.example.weatherapp.weather.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.weather.data.model.WeatherResponse
import com.example.weatherapp.weather.utils.ConvertersWeather.convertMoonPhase
import com.example.weatherapp.weather.utils.ConvertersWeather.formatTimeAstro

@Composable
fun CardMoon(weatherResponse: WeatherResponse) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.extraLarge)
            .background(Color(0x1A000000))
            .padding(35.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Заход луны",
                    color = Color(0xFFd2d6e1),
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = formatTimeAstro(weatherResponse.forecast.forecastday[0].astro.moonset),
                    color = Color(0xFFFFFFFF),
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Image(
                painter = painterResource(R.drawable.moon),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Восход луны",
                    color = Color(0xFFd2d6e1),
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = formatTimeAstro(weatherResponse.forecast.forecastday[0].astro.moonrise),
                    color = Color(0xFFFFFFFF),
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
        Text(
            text = convertMoonPhase(weatherResponse.forecast.forecastday[0].astro.moon_phase),
            color = Color(0xFFFFFFFF),
            style = MaterialTheme.typography.bodySmall,
        )
    }
}