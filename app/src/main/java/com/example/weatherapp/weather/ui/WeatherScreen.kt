package com.example.weatherapp.weather.ui

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weatherapp.shared.data.api.State
import com.example.weatherapp.shared.navigation.AppDestinations
import com.example.weatherapp.weather.data.model.WeatherResponse
import com.example.weatherapp.weather.domain.model.CustomDrawerState
import com.example.weatherapp.weather.domain.model.isOpened
import com.example.weatherapp.weather.ui.sections.WeatherContentContainer
import com.example.weatherapp.weather.ui.sections.WeatherSideMenu
import com.example.weatherapp.weather.utils.getGradientForSunTime
import kotlin.math.roundToInt

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun WeatherScreen(navController: NavController) {
    val weatherViewModel = hiltViewModel<WeatherViewModel>()
    val state by weatherViewModel.state.collectAsState()

    var drawerState by remember { mutableStateOf(CustomDrawerState.Closed) }

    val configuration = LocalConfiguration.current
    val density = LocalDensity.current.density

    val screenWidth = remember {
        derivedStateOf { (configuration.screenWidthDp * density).roundToInt() }
    }
    val offsetValue by remember { derivedStateOf { (screenWidth.value / 4.5).dp } }

    val animatedOffset by animateDpAsState(
        targetValue = if (drawerState.isOpened()) offsetValue else 0.dp,
        label = "Animated Offset"
    )

    val animatedScale by animateFloatAsState(
        targetValue = if (drawerState.isOpened()) 0.9f else 1f,
        label = "Animated Scale"
    )

    val defaultGradient = remember {
        Brush.verticalGradient(
            listOf(
                Color(0xFF4d4f88),
                Color(0xFF635a93),
                Color(0xFF916ea4),
                Color(0xFFa9718e),
                Color(0xFFb37480),
            )
        )
    }

    when (state) {
        is State.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(defaultGradient),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator(color = Color.White)
            }
        }

        is State.Success -> {
            val weatherResponse = (state as State.Success<WeatherResponse>).data
            val sunset = weatherResponse.forecast.forecastday[0].astro.sunset
            val sunrise = weatherResponse.forecast.forecastday[0].astro.sunrise
            val currentTime = weatherResponse.location.localtime


            val gradient = getGradientForSunTime(sunrise, sunset, currentTime)

            Box(
                modifier = Modifier
                    .background(gradient)
                    .fillMaxSize()
            ) {
                WeatherSideMenu(
                    onClickSearch = { navController.navigate(AppDestinations.Search) },
                    onClickSettings = { navController.navigate(AppDestinations.Settings) }
                )
                WeatherContentContainer(
                    modifier = Modifier
                        .offset(x = animatedOffset)
                        .scale(scale = animatedScale),
                    drawerState = drawerState,
                    onDrawerClick = { drawerState = it },
                    gradientColor = gradient,
                    weatherResponse = weatherResponse
                )
            }

        }

        is State.Error -> {
            val error = (state as State.Error).networkError.name
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(defaultGradient),
                contentAlignment = Alignment.Center,
            ) {
                Text(error)
            }
        }

        else -> {}
    }
}


