package com.zenika.handson.spring.repositories.inmemory

import com.zenika.handson.spring.entities.City
import com.zenika.handson.spring.entities.Weather
import com.zenika.handson.spring.repositories.WeatherRepository
import java.time.LocalDate


class WeatherRepositoryInMemory : WeatherRepository {
    override fun getDailyWeather(city: City): List<Weather> {
        return listOf(
            Weather(LocalDate.of(2021, 2, 23), "cloudy", 28.0, 27.0)
        )
    }
}
