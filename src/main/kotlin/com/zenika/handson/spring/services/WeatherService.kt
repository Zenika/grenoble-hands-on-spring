package com.zenika.handson.spring.services

import com.zenika.handson.spring.repositories.CitiesRepository
import com.zenika.handson.spring.repositories.WeatherRepository
import org.springframework.stereotype.Service

@Service
class WeatherService(private val cityRepository: CitiesRepository, private val weatherRepository: WeatherRepository) {

    fun getDailyWeatherForCity(name: String) = cityRepository.getByName(name)
        ?.let { weatherRepository.getDailyWeather(it) }

}
