package com.example.weatherapp.weather.utils

import com.example.weatherapp.R

fun ConverterWeatherIcon(url: String): Int {
    val icon = when (url) {
        //иконки для ночного времени
        "//cdn.weatherapi.com/weather/64x64/night/113.png" -> R.drawable.ic_night
        "//cdn.weatherapi.com/weather/64x64/night/116.png" -> R.drawable.ic_cloudy_night
        "//cdn.weatherapi.com/weather/64x64/night/119.png" -> R.drawable.ic_cloudy_night
        "//cdn.weatherapi.com/weather/64x64/night/122.png" -> R.drawable.ic_cloudy_night
        "//cdn.weatherapi.com/weather/64x64/night/143.png" -> R.drawable.ic_fog
        "//cdn.weatherapi.com/weather/64x64/night/176.png" -> R.drawable.ic_rain_night
        "//cdn.weatherapi.com/weather/64x64/night/179.png" -> R.drawable.ic_snow_night
        "//cdn.weatherapi.com/weather/64x64/night/182.png" -> R.drawable.ic_show_night
        "//cdn.weatherapi.com/weather/64x64/night/185.png" -> R.drawable.ic_rain_night
        "//cdn.weatherapi.com/weather/64x64/night/200.png" -> R.drawable.ic_lightning_night
        "//cdn.weatherapi.com/weather/64x64/night/227.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/night/230.png" -> R.drawable.ic_cloudy_windy_fog
        "//cdn.weatherapi.com/weather/64x64/night/248.png" -> R.drawable.ic_fog
        "//cdn.weatherapi.com/weather/64x64/night/260.png" -> R.drawable.ic_fog
        "//cdn.weatherapi.com/weather/64x64/night/263.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/night/266.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/night/281.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/night/284.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/night/293.png" -> R.drawable.ic_rain_night
        "//cdn.weatherapi.com/weather/64x64/night/296.png" -> R.drawable.ic_rain
        "//cdn.weatherapi.com/weather/64x64/night/299.png" -> R.drawable.ic_rain_night
        "//cdn.weatherapi.com/weather/64x64/night/302.png" -> R.drawable.ic_rain
        "//cdn.weatherapi.com/weather/64x64/night/305.png" -> R.drawable.ic_show_night
        "//cdn.weatherapi.com/weather/64x64/night/308.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/night/311.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/night/314.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/night/317.png" -> R.drawable.ic_cloudy_windy_snow
        "//cdn.weatherapi.com/weather/64x64/night/320.png" -> R.drawable.ic_cloudy_windy_snow
        "//cdn.weatherapi.com/weather/64x64/night/323.png" -> R.drawable.ic_snow_night
        "//cdn.weatherapi.com/weather/64x64/night/326.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/night/329.png" -> R.drawable.ic_snow_night
        "//cdn.weatherapi.com/weather/64x64/night/332.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/night/335.png" -> R.drawable.ic_snow_night
        "//cdn.weatherapi.com/weather/64x64/night/338.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/night/350.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/night/353.png" -> R.drawable.ic_rain_night
        "//cdn.weatherapi.com/weather/64x64/night/356.png" -> R.drawable.ic_show_night
        "//cdn.weatherapi.com/weather/64x64/night/359.png" -> R.drawable.ic_show_night
        "//cdn.weatherapi.com/weather/64x64/night/362.png" -> R.drawable.ic_snow_night
        "//cdn.weatherapi.com/weather/64x64/night/365.png" -> R.drawable.ic_snow_night
        "//cdn.weatherapi.com/weather/64x64/night/368.png" -> R.drawable.ic_snow_night
        "//cdn.weatherapi.com/weather/64x64/night/371.png" -> R.drawable.ic_snow_night
        "//cdn.weatherapi.com/weather/64x64/night/374.png" -> R.drawable.ic_snow_night
        "//cdn.weatherapi.com/weather/64x64/night/377.png" -> R.drawable.ic_snow_night
        "//cdn.weatherapi.com/weather/64x64/night/386.png" -> R.drawable.ic_lightning_night
        "//cdn.weatherapi.com/weather/64x64/night/389.png" -> R.drawable.ic_coudy_lightning_rain
        "//cdn.weatherapi.com/weather/64x64/night/392.png" -> R.drawable.ic_lightning_snow_windy_night
        "//cdn.weatherapi.com/weather/64x64/night/395.png" -> R.drawable.ic_cloudy_windy_snow
        //иконки для днемного времени
        "//cdn.weatherapi.com/weather/64x64/day/113.png" -> R.drawable.ic_sunny
        "//cdn.weatherapi.com/weather/64x64/day/116.png" -> R.drawable.ic_cloudy_sunny
        "//cdn.weatherapi.com/weather/64x64/day/119.png" -> R.drawable.ic_cloudy
        "//cdn.weatherapi.com/weather/64x64/day/122.png" -> R.drawable.ic_cloudy
        "//cdn.weatherapi.com/weather/64x64/day/143.png" -> R.drawable.ic_fog
        "//cdn.weatherapi.com/weather/64x64/day/176.png" -> R.drawable.ic_rain_sunny
        "//cdn.weatherapi.com/weather/64x64/day/179.png" -> R.drawable.ic_show_sunny
        "//cdn.weatherapi.com/weather/64x64/day/182.png" -> R.drawable.ic_show_sunny
        "//cdn.weatherapi.com/weather/64x64/day/185.png" -> R.drawable.ic_rain_sunny
        "//cdn.weatherapi.com/weather/64x64/day/200.png" -> R.drawable.ic_lightning_sunny
        "//cdn.weatherapi.com/weather/64x64/day/227.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/day/230.png" -> R.drawable.ic_cloudy_windy_fog
        "//cdn.weatherapi.com/weather/64x64/day/248.png" -> R.drawable.ic_fog
        "//cdn.weatherapi.com/weather/64x64/day/260.png" -> R.drawable.ic_fog
        "//cdn.weatherapi.com/weather/64x64/day/263.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/day/266.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/day/281.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/day/284.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/day/293.png" -> R.drawable.ic_rain_sunny
        "//cdn.weatherapi.com/weather/64x64/day/296.png" -> R.drawable.ic_rain
        "//cdn.weatherapi.com/weather/64x64/day/299.png" -> R.drawable.ic_rain_sunny
        "//cdn.weatherapi.com/weather/64x64/day/302.png" -> R.drawable.ic_rain
        "//cdn.weatherapi.com/weather/64x64/day/305.png" -> R.drawable.ic_show_sunny
        "//cdn.weatherapi.com/weather/64x64/day/308.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/day/311.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/day/314.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/day/317.png" -> R.drawable.ic_cloudy_windy_snow
        "//cdn.weatherapi.com/weather/64x64/day/320.png" -> R.drawable.ic_cloudy_windy_snow
        "//cdn.weatherapi.com/weather/64x64/day/323.png" -> R.drawable.ic_snow_sunny
        "//cdn.weatherapi.com/weather/64x64/day/326.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/day/329.png" -> R.drawable.ic_snow_sunny
        "//cdn.weatherapi.com/weather/64x64/day/332.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/day/335.png" -> R.drawable.ic_snow_sunny
        "//cdn.weatherapi.com/weather/64x64/day/338.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/day/350.png" -> R.drawable.ic_snow
        "//cdn.weatherapi.com/weather/64x64/day/353.png" -> R.drawable.ic_rain_sunny
        "//cdn.weatherapi.com/weather/64x64/day/356.png" -> R.drawable.ic_show_sunny
        "//cdn.weatherapi.com/weather/64x64/day/359.png" -> R.drawable.ic_show_sunny
        "//cdn.weatherapi.com/weather/64x64/day/362.png" -> R.drawable.ic_show_sunny
        "//cdn.weatherapi.com/weather/64x64/day/365.png" -> R.drawable.ic_show_sunny
        "//cdn.weatherapi.com/weather/64x64/day/368.png" -> R.drawable.ic_show_sunny
        "//cdn.weatherapi.com/weather/64x64/day/371.png" -> R.drawable.ic_show_sunny
        "//cdn.weatherapi.com/weather/64x64/day/374.png" -> R.drawable.ic_show_sunny
        "//cdn.weatherapi.com/weather/64x64/day/377.png" -> R.drawable.ic_show_sunny
        "//cdn.weatherapi.com/weather/64x64/day/386.png" -> R.drawable.ic_lightning_sunny
        "//cdn.weatherapi.com/weather/64x64/day/389.png" -> R.drawable.ic_coudy_lightning_rain
        "//cdn.weatherapi.com/weather/64x64/day/392.png" -> R.drawable.ic_lightning_snow_windy_sunny
        "//cdn.weatherapi.com/weather/64x64/day/395.png" -> R.drawable.ic_cloudy_windy_snow
        else -> {
            R.drawable.ic_cloudy
        }
    }

    return icon
}