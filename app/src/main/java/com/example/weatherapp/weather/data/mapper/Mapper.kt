package com.example.weatherapp.weather.data.mapper

import com.example.weatherapp.weather.data.model.AirQuality
import com.example.weatherapp.weather.data.model.Astro
import com.example.weatherapp.weather.data.model.Condition
import com.example.weatherapp.weather.data.model.Current
import com.example.weatherapp.weather.data.model.Day
import com.example.weatherapp.weather.data.model.Forecast
import com.example.weatherapp.weather.data.model.Forecastday
import com.example.weatherapp.weather.data.model.Hour
import com.example.weatherapp.weather.data.model.Location
import com.example.weatherapp.weather.data.model.WeatherResponse
import com.example.weatherapp.weather.data.modelDTO.AirQualityDTO
import com.example.weatherapp.weather.data.modelDTO.AstroDTO
import com.example.weatherapp.weather.data.modelDTO.ConditionDTO
import com.example.weatherapp.weather.data.modelDTO.CurrentDTO
import com.example.weatherapp.weather.data.modelDTO.DayDTO
import com.example.weatherapp.weather.data.modelDTO.ForecastDTO
import com.example.weatherapp.weather.data.modelDTO.ForecastdayDTO
import com.example.weatherapp.weather.data.modelDTO.HourDTO
import com.example.weatherapp.weather.data.modelDTO.LocationDTO
import com.example.weatherapp.weather.data.modelDTO.WeatherResponseDTO

fun WeatherResponseDTO.toWeatherResponce(): WeatherResponse {
    return WeatherResponse(
        current = this.current.toCurrent(),
        forecast = this.forecast.toForecast(),
        location = this.location.toLocation()
    )
}

fun LocationDTO?.toLocation(): Location {
    return Location(
        country = this?.country ?: "",
        name = this?.name ?: "",
        localtime = this?.localtime ?: "",
        region = this?.region ?: "",
    )
}

fun ForecastDTO?.toForecast(): Forecast {
    return Forecast(
        forecastday = this?.forecastday?.map { it.toForecastday() } ?: emptyList()
    )
}

fun ForecastdayDTO?.toForecastday(): Forecastday {
    return Forecastday(
        astro = this?.astro.toAstro(),
        date = this?.date ?: "",
        day = this?.day.toDay(),
        hour = this?.hour?.map { it.toHour() } ?: emptyList()
    )
}

fun DayDTO?.toDay(): Day {
    return Day(
        condition = this?.condition.toCondition(),
        daily_chance_of_rain = this?.daily_chance_of_rain ?: 0,
        maxtemp_c = this?.maxtemp_c ?: 0.0,
        maxtemp_f = this?.maxtemp_f ?: 0.0,
        mintemp_c = this?.mintemp_c ?: 0.0,
        mintemp_f = this?.mintemp_f ?: 0.0
    )
}

fun HourDTO?.toHour(): Hour {
    return Hour(
        chance_of_rain = this?.chance_of_rain ?: 0,
        condition = this?.condition.toCondition(),
        temp_c = this?.temp_c ?: 0.0,
        temp_f = this?.temp_f ?: 0.0,
        time = this?.time ?: ""
    )
}

fun CurrentDTO?.toCurrent(): Current {
    return Current(
        air_quality = this?.air_quality.toAirQuality(),
        condition = this?.condition.toCondition(),
        dewpoint_c = this?.dewpoint_c ?: 0.0,
        dewpoint_f = this?.dewpoint_f ?: 0.0,
        gust_kph = this?.gust_kph ?: 0.0,
        gust_mph = this?.gust_mph ?: 0.0,
        humidity = this?.humidity ?: 0,
        pressure_in = this?.pressure_in ?: 0.0,
        pressure_mb = this?.pressure_mb ?: 0.0,
        temp_c = this?.temp_c ?: 0.0,
        temp_f = this?.temp_f ?: 0.0,
        uv = this?.uv ?: 0.0,
        vis_km = this?.vis_km ?: 0.0,
        vis_miles = this?.vis_miles ?: 0.0,
        wind_dir = this?.wind_dir ?: "",
        wind_kph = this?.wind_kph ?: 0.0,
        wind_mph = this?.wind_mph ?: 0.0,
        feelslike_f = this?.feelslike_f ?: 0.0,
        feelslike_c = this?.feelslike_c ?: 0.0
    )
}

fun AirQualityDTO?.toAirQuality(): AirQuality {
    return AirQuality(
        us_epa_index = this?.us_epa_index ?: 0
    )
}

fun ConditionDTO?.toCondition(): Condition {
    return Condition(
        icon = this?.icon ?: "",
        text = this?.text ?: ""
    )
}

fun AstroDTO?.toAstro(): Astro {
    return Astro(
        moon_phase = this?.moon_phase ?: "",
        moonrise = this?.moonrise ?: "",
        moonset = this?.moonset ?: "",
        sunrise = this?.sunrise ?: "",
        sunset = this?.sunset ?: ""
    )
}

