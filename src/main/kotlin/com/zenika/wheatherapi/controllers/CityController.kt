package com.zenika.wheatherapi.controllers

import com.zenika.wheatherapi.model.City
import com.zenika.wheatherapi.model.GeoPosition
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/cities")
class CityController {

    @GetMapping
    fun getAllCities(): Collection<City> = listOf(
        City("Grenoble", GeoPosition(5.0, 45.0)),
        City("Lyon", GeoPosition(3.0, 47.0)),
    )
}