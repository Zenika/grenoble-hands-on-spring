package com.zenika.handson.spring.services

import com.zenika.handson.spring.entities.Weather
import com.zenika.handson.spring.repositories.CitiesRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class WeatherService(private val cityRepository: CitiesRepository) {

    fun getDailyWeatherForCity(name: String) = cityRepository.getByName(name)
        ?.let { listOf(Weather(LocalDate.of(2021, 2, 23), "cloudy", 28.0, 27.0)) }

}
