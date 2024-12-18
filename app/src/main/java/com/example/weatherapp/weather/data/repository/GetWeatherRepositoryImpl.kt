package com.example.weatherapp.weather.data.repository

import com.example.weatherapp.shared.data.api.ApiService
import com.example.weatherapp.shared.data.api.NetworkError
import com.example.weatherapp.shared.data.api.State
import com.example.weatherapp.weather.data.mapper.toWeatherResponce
import com.example.weatherapp.weather.data.model.WeatherResponse
import com.example.weatherapp.weather.domain.repository.GetWeatherRepository
import java.util.Locale


const val key = "8e387ae0dee64b6497c155850241112"

class GetWeatherRepositoryImpl(private val apiService: ApiService) : GetWeatherRepository {
    override suspend fun getWeather(): State<WeatherResponse> {

        return try {
            val response = apiService.getWeather(
                key = key,
                city = "Оттава",
                days = 3,
                aqi = "yes",
                alerts = "yes",
                language = getCurrentLanguage()
            )
            if (response.isSuccessful) {
                val body = response.body()?.toWeatherResponce()
                if (body != null) {
                    State.Success(body)
                } else {
                    State.Error(NetworkError.UNKNOWN, Throwable("No data found in the response"))
                }
            } else {
                State.Error(NetworkError.UNKNOWN, Throwable("An unexpected error occurred"))
            }

        } catch (e: Exception) {
            State.Error(NetworkError.UNKNOWN, Throwable("An unexpected error occurred", e))
        }
    }
}

fun getCurrentLanguage(): String {
    val locale = Locale.getDefault()
    return locale.language
}
