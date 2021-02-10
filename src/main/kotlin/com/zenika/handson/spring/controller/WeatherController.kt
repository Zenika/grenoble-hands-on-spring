package com.zenika.handson.spring.controller

import com.zenika.handson.spring.entities.Weather
import com.zenika.handson.spring.repositories.CitiesRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/cities")
class WeatherController(private val citiesRepository: CitiesRepository) {

    @GetMapping("/{name}/weather")
    fun getWeather(@PathVariable name: String): ResponseEntity<List<Weather>> = citiesRepository.getByName(name)
        ?.let { listOf(Weather(LocalDate.of(2021, 2, 23), "cloudy", 28.0, 27.0)) }
        ?.let { ResponseEntity.ok(it) }
        ?: ResponseEntity.notFound().build()

}
