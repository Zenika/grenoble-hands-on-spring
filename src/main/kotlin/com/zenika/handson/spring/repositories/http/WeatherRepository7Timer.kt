package com.zenika.handson.spring.repositories.http

import com.fasterxml.jackson.databind.ObjectMapper
import com.zenika.handson.spring.entities.City
import com.zenika.handson.spring.entities.Weather
import com.zenika.handson.spring.repositories.WeatherRepository
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Repository
import org.springframework.web.client.getForObject


@Repository
class WeatherRepository7Timer(restTemplateBuilder: RestTemplateBuilder, val objectMapper: ObjectMapper) :
    WeatherRepository {
    private val restTemplate = restTemplateBuilder.build()

    override fun getDailyWeather(city: City): List<Weather> {
        return getResponse(city, "civillight")
            .let { objectMapper.readValue(it, DailyWeather7Timer::class.java) }
            .let { Weather7TimerMapper.toDomain(it) }
    }

    private fun getResponse(city: City, product: String) =
        restTemplate.getForObject<String>("http://www.7timer.info/bin/api.pl?lon=${city.position.longitude}&lat=${city.position.latitude}&product=$product&output=json")
}
