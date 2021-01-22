package com.zenika.wheatherapi.controllers

import com.zenika.wheatherapi.model.City
import com.zenika.wheatherapi.repositories.CityRepository
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/cities")
class CityController(val cityRepository: CityRepository) {

    @GetMapping
    fun getAllCities(): Iterable<City> = cityRepository.findAll(Sort.by("name"))

}