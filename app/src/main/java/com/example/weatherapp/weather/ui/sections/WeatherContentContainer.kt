package com.example.weatherapp.weather.ui.sections

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.weatherapp.weather.data.model.WeatherResponse
import com.example.weatherapp.weather.domain.model.CustomDrawerState
import com.example.weatherapp.weather.domain.model.opposite
import com.example.weatherapp.weather.ui.components.Header
import com.example.weatherapp.weather.utils.coloredShadow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WeatherContentContainer(
    modifier: Modifier = Modifier,
    drawerState: CustomDrawerState,
    onDrawerClick: (CustomDrawerState) -> Unit,
    gradientColor: Brush,
    weatherResponse: WeatherResponse
) {
    Column(
        modifier = modifier
            .coloredShadow(
                color = Color.Black,
                alpha = 0.3f,
                shadowRadius = 50.dp
            )
            .fillMaxSize()
            .clip(
                if (drawerState == CustomDrawerState.Opened) RoundedCornerShape(
                    bottomStart = 20.dp, topStart = 20.dp
                )
                else RoundedCornerShape(
                    0.dp
                )
            )
            .background(gradientColor)
            .clickable(enabled = drawerState == CustomDrawerState.Opened) {
                onDrawerClick(CustomDrawerState.Closed)
            }
    ) {
        Header(onClick = { onDrawerClick(drawerState.opposite()) }, weatherResponse)
        ForecastContent(weatherResponse)
    }
}
