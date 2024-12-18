package com.example.weatherapp.shared.data.di

import com.example.weatherapp.shared.data.api.ApiConstants
import com.example.weatherapp.shared.data.api.ApiService
import com.example.weatherapp.weather.data.repository.GetWeatherRepositoryImpl
import com.example.weatherapp.weather.domain.repository.GetWeatherRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun providerRetrofit(): ApiService {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val contentType = "application/json".toMediaType()
        val json = Json {
            ignoreUnknownKeys = true
        }
        return Retrofit.Builder()
            .baseUrl(ApiConstants.base_url)
            .addConverterFactory(json.asConverterFactory(contentType))
            .client(client)
            .build()
            .create(ApiService::class.java)
    }


    @Provides
    @Singleton
    fun provideGetWeather(apiService: ApiService): GetWeatherRepository {
        return GetWeatherRepositoryImpl(apiService)
    }
}