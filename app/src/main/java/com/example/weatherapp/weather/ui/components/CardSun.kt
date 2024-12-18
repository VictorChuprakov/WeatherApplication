package com.example.weatherapp.weather.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.weather.data.model.WeatherResponse
import com.example.weatherapp.weather.utils.ConvertersWeather.calculateSunProgress
import com.example.weatherapp.weather.utils.ConvertersWeather.parseDataTimeToTime
import com.example.weatherapp.weather.utils.ConvertersWeather.parseTimeAMPM
import java.lang.Math.toRadians
import java.time.LocalTime
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CardSun(weatherResponse: WeatherResponse) {
    val sunriseTime = parseTimeAMPM(weatherResponse.forecast.forecastday[0].astro.sunrise)
    val sunsetTime = parseTimeAMPM(weatherResponse.forecast.forecastday[0].astro.sunset)
    val currentTime = parseDataTimeToTime(weatherResponse.location.localtime)
    val progress = calculateSunProgress(sunriseTime, sunsetTime, currentTime)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.extraLarge)
            .background(Color(0x1A000000))
            .padding(15.dp),
    ) {
        SunGraph(progress, currentTime, sunriseTime, sunsetTime)
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 35.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Восход",
                    color = Color(0xFFd2d6e1),
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = sunriseTime.toString(),
                    color = Color(0xFFFFFFFF),
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Закат",
                    color = Color(0xFFd2d6e1),
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = sunsetTime.toString(),
                    color = Color(0xFFFFFFFF),
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Composable
private fun SunGraph(
    progress: Float,
    currentTime: LocalTime,
    sunriseTime: LocalTime,
    sunsetTime: LocalTime
) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 40.dp)
    ) {
        val radiusX = size.width / 2.5f
        val radiusY = size.height / 1.1f
        val centerX = size.width / 2
        val centerY = size.height

        val sunLineColor = when {
            currentTime.isBefore(sunriseTime)  &&  currentTime.isAfter(sunsetTime) -> Color(0xFFFFD700)
            currentTime.isBefore(LocalTime.MIDNIGHT)  ||  currentTime.isAfter(sunriseTime) ->  Color(0xFFFFD700)
            else -> Color(0xFFd2d6e1)
        }

        clipRect(left = 0f, top = -10f, right = size.width, bottom = size.height) {
            drawArc(
                color = Color(0xFFd2d6e1),
                topLeft = Offset(centerX - radiusX, centerY - radiusY),
                size = Size(radiusX * 2, radiusY * 2),
                startAngle = 180f + 180f * progress,
                sweepAngle = 180f,
                useCenter = false,
                style = Stroke(width = 1.5.dp.toPx())
            )

            drawArc(
                color = sunLineColor,
                topLeft = Offset(centerX - radiusX, centerY - radiusY),
                size = Size(radiusX * 2, radiusY * 2),
                startAngle = 180f,
                sweepAngle = 180f * progress,
                useCenter = false,
                style = Stroke(width = 1.5.dp.toPx())
            )



            if (currentTime.isAfter(sunriseTime) && currentTime.isBefore(sunsetTime)) {
                val angle = 180f * progress
                val sunX = centerX - radiusX * cos(toRadians(angle.toDouble())).toFloat()
                val sunY = centerY - radiusY * sin(toRadians(angle.toDouble())).toFloat()

                drawCircle(
                    color = Color(0x80FEC62B),
                    center = Offset(sunX, sunY),
                    radius = 13.dp.toPx()
                )
                drawCircle(
                    color = Color(0xFFfec62b),
                    center = Offset(sunX, sunY),
                    radius = 10.dp.toPx()
                )
            }
        }

        // Drawing the horizon line
        drawLine(
            start = Offset(0f, size.height),
            end = Offset(size.width, size.height),
            color = Color(0xFFd2d6e1),
            strokeWidth = 4.0f
        )
    }
}

