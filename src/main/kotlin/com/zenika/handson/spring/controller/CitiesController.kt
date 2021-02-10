package com.zenika.handson.spring.controller

import com.zenika.handson.spring.entities.City
import com.zenika.handson.spring.entities.GeoPosition
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cities")
class CitiesController {
    private val cities = listOf(
        City("GRENOBLE", GeoPosition(45.183916, 5.703630)),
        City("LYON", GeoPosition(45.767443, 4.858798)),
    )

    @GetMapping
    fun geCities() = cities

    @GetMapping("/{name}")
    fun getCity(@PathVariable name: String) = cities.find { it.name == name }
        ?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
}