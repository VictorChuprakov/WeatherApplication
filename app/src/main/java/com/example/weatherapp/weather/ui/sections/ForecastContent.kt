package com.example.weatherapp.weather.ui.sections

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.weather.data.model.WeatherResponse
import com.example.weatherapp.weather.ui.components.CardAirQuality
import com.example.weatherapp.weather.ui.components.CardCurrent
import com.example.weatherapp.weather.ui.components.CardDay
import com.example.weatherapp.weather.ui.components.CardGrid
import com.example.weatherapp.weather.ui.components.CardHour
import com.example.weatherapp.weather.ui.components.CardMoon
import com.example.weatherapp.weather.ui.components.CardSun
import com.example.weatherapp.weather.ui.components.WeatherEndTimeView


@Composable
fun ForecastContent(weatherResponse: WeatherResponse) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
    ) {
        item {
            CardCurrent(weatherResponse)
            Spacer(modifier = Modifier.height(10.dp))
            CardHour(weatherResponse)
            Spacer(modifier = Modifier.height(10.dp))
            CardDay(weatherResponse)
            Spacer(modifier = Modifier.height(10.dp))
            CardAirQuality(weatherResponse)
            Spacer(modifier = Modifier.height(10.dp))
            CardGrid(weatherResponse)
            Spacer(modifier = Modifier.height(10.dp))
            CardSun(weatherResponse)
            Spacer(modifier = Modifier.height(10.dp))
            CardMoon(weatherResponse)
            Spacer(modifier = Modifier.height(10.dp))
            WeatherEndTimeView()
        }
    }
}
