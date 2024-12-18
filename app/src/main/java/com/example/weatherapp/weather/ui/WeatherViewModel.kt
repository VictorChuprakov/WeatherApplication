package com.example.weatherapp.weather.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.shared.data.api.State
import com.example.weatherapp.weather.data.model.WeatherResponse
import com.example.weatherapp.weather.domain.repository.GetWeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: GetWeatherRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<State<WeatherResponse>>(State.Idle)
    val state: StateFlow<State<WeatherResponse>> = _state.asStateFlow()

    init {
        fetchWeather()
    }


    private fun fetchWeather() {
        _state.value = State.Loading
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getWeather()
            _state.value = result
        }
    }

}