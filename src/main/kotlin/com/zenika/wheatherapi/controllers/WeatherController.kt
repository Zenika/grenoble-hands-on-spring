package com.zenika.wheatherapi.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/weather")
class WeatherController {

    @GetMapping("/{cityId}")
    fun getWeather(@PathVariable cityId: String): String {
        println("$cityId")
        return "fine"
    }
}